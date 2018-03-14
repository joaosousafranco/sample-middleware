package com.jsfsi.sample.modules.patient.resources;

import com.jsfsi.sample.core.sample.BVetClient;
import com.jsfsi.sample.core.sample.BVetPatientServices;
import com.jsfsi.sample.core.security.User;
import com.jsfsi.sample.extensibility.BvetMiddlewareConfiguration;
import com.jsfsi.sample.extensibility.patient.Patient;
import com.jsfsi.sample.modules.patient.Version;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;
import io.dropwizard.auth.Auth;
import org.glassfish.jersey.server.ContainerRequest;
import retrofit2.Call;
import retrofit2.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path(Version.NAME + Version.PATIENT_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class PatientDetailsResource extends DropwizardResource<DropwizardConfiguration> {
    private BvetMiddlewareConfiguration getBvetMiddlewareConfiguration() {
        return (BvetMiddlewareConfiguration)super.getConfiguration();
    }

    @Override
    public void initialize() {
        HateoasLinkInjector.injectDetails();
    }

    @GET
    @Path("/{id}")
    public Patient patient(@Auth User user, @PathParam("id") String id, @Context ContainerRequest request) throws IOException {
        BVetPatientServices client = BVetClient.getClient(
                getBvetMiddlewareConfiguration().getBvetApiUrl(),
                user,
                BVetPatientServices.class
        );

        Call<Patient> detailCall = client.detail(id);

        Response<Patient> detailResponse = detailCall.execute();

        if(detailResponse.code() == 401){
            javax.ws.rs.core.Response response = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        if(detailResponse.code() == 404){
            javax.ws.rs.core.Response response = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND).build();
            throw new WebApplicationException(response);
        }

        return detailResponse.body();
    }
}
