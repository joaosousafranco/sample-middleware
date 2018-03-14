package com.jsfsi.sample.modules.oauth.resources;

import com.google.gson.Gson;
import com.jsfsi.sample.core.sample.BVetClient;
import com.jsfsi.sample.core.sample.BVetSecurityServices;
import com.jsfsi.sample.core.hateoas.HateoasLinkGenerator;
import com.jsfsi.sample.core.security.User;
import com.jsfsi.sample.extensibility.BvetMiddlewareConfiguration;
import com.jsfsi.sample.extensibility.user.OAuthCredentials;
import com.jsfsi.sample.extensibility.user.Token;
import com.jsfsi.sample.extensibility.user.TokenType;
import com.jsfsi.sample.modules.oauth.Version;
import com.jsfsi.sample.modules.oauth.authorization.BVetAuthenticator;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;
import io.dropwizard.auth.Auth;
import org.assertj.core.util.Strings;
import org.glassfish.jersey.server.ContainerRequest;
import retrofit2.Call;
import retrofit2.http.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.UUID;

/*
USAGE:

curl -v http://192.168.1.137:8000/1.0/oauth2/token -X POST -d '{ "username" : "silvia", "password" : "@saobento"}' -H "Content-type: application/json"
curl -v http://localhost:8000/1.0/oauth2/user -X GET -H "Content-type: application/json" -H "Authorization: Bearer b42206f5-3900-410f-a3a2-519aeaf1059e"

 */


@Path(Version.NAME + Version.OAUTH_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class BVetOAuthResource extends DropwizardResource<DropwizardConfiguration>  {

    @Override
    public void initialize() {
        HateoasLinkInjector.inject();
    }

    private BvetMiddlewareConfiguration getBvetMiddlewareConfiguration() {
        return (BvetMiddlewareConfiguration)super.getConfiguration();
    }

    @POST
    @Path("/token")
    public Token token(@Body String credentialsText, @Context ContainerRequest request) throws IOException {
        OAuthCredentials credentials;
        try {
            credentials = new Gson().fromJson(credentialsText,OAuthCredentials.class);
        }catch (Exception e){
            Response response = Response.status(Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        if(Strings.isNullOrEmpty(credentials.getUsername()) || Strings.isNullOrEmpty(credentials.getPassword()) ){
            Response response = Response.status(Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        BVetSecurityServices authenticationClient = BVetClient.getClient(getBvetMiddlewareConfiguration().getBvetApiUrl(),BVetSecurityServices.class);
        Call<String> authenticationCall = authenticationClient.authenticate(credentials);
        retrofit2.Response<String> authenticationResponse = authenticationCall.execute();

        if(authenticationResponse.code() < 200 || authenticationResponse.code() > 399){
            Response response = Response.status(Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        String cookie = authenticationResponse.headers().get("Set-Cookie");
        if(cookie == null){
            Response response = Response.status(Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        User infoUser = new User();
        infoUser.setCookie(cookie);

        BVetSecurityServices infoClient = BVetClient.getClient(getBvetMiddlewareConfiguration().getBvetApiUrl(),infoUser,BVetSecurityServices.class);
        Call<User> userCall = infoClient.user();
        retrofit2.Response<User> userResponse = userCall.execute();
        User user = userResponse.body();
        user.setCookie(cookie);

        UUID accessToken;
        do {
            accessToken = UUID.randomUUID();
        }
        while(BVetAuthenticator.tokens.containsKey(accessToken));

        BVetAuthenticator.tokens.put(accessToken,user);

        Token result = new Token();
        result.setToken(accessToken.toString());
        result.setType(TokenType.Bearer);

        result.getUser().add(
                HateoasLinkGenerator.get(request,String.format("%s/user",Version.NAME + Version.OAUTH_PATH))
        );

        result.getPatient().add(
                HateoasLinkGenerator.get(request,"/1.0/patient/species")
        );
        result.getPatient().add(
                HateoasLinkGenerator.get(request,"/1.0/patient/states")
        );
        result.getPatient().add(
                HateoasLinkGenerator.get(request,"/1.0/patient/search")
        );

        result.getStock().add(
                HateoasLinkGenerator.get(request,"/1.0/stock/filters")
        );
        result.getStock().add(
                HateoasLinkGenerator.get(request,"/1.0/stock/use/{id}")
        );

        return result;
    }

    @GET
    @Path("/user")
    public com.jsfsi.sample.extensibility.user.User user(@Auth User user){
        com.jsfsi.sample.extensibility.user.User responseUser = new com.jsfsi.sample.extensibility.user.User();
        responseUser.setEmail(user.getEmail());
        responseUser.setName(user.getName());
        responseUser.setRoles(user.getRoles());

        return responseUser;
    }
}
