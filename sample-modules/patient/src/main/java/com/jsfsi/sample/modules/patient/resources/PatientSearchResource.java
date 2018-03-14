package com.jsfsi.sample.modules.patient.resources;


import com.jsfsi.sample.core.sample.BVetClient;
import com.jsfsi.sample.core.sample.BVetParametersServices;
import com.jsfsi.sample.core.sample.BVetPatientServices;
import com.jsfsi.sample.core.hateoas.HateoasLinkGenerator;
import com.jsfsi.sample.core.security.User;
import com.jsfsi.sample.extensibility.BvetMiddlewareConfiguration;
import com.jsfsi.sample.extensibility.patient.Patient;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.modules.patient.Version;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;
import io.dropwizard.auth.Auth;
import org.glassfish.jersey.server.ContainerRequest;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

@Path(Version.NAME + Version.PATIENT_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class PatientSearchResource extends DropwizardResource<DropwizardConfiguration> {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PatientSearchResource.class);

    private BvetMiddlewareConfiguration getBvetMiddlewareConfiguration() {
        return (BvetMiddlewareConfiguration)super.getConfiguration();
    }

    @Override
    public void initialize() {
        HateoasLinkInjector.injectSearch();
        HateoasLinkInjector.injectFilters();
    }

    @GET
    @Path("/species")
    public Hashtable<String,String> species(@Auth User user){
        Hashtable<String,String> result = new Hashtable<>();

        try
        {
            result = getBVetList(user,"ESPEC","param_nome","param_cod");
        }catch (IOException ioError){
            logger.warn("Failed to get species from sample",ioError);
        }

        return result;
    }

    @GET
    @Path("/states")
    public Hashtable<String,String> states(@Auth User user){
        Hashtable<String,String> result = new Hashtable<>();

        try
        {
            result = getBVetList(user,"SIT","param_nome","param_cod");
        }catch (IOException ioError){
            logger.warn("Failed to get species from sample",ioError);
        }

        return result;
    }

    @GET
    @Path("/search")
    public List<Patient> search(@Auth User user,
                                @QueryParam("patientName") String patientName,
                                @QueryParam("clientName") String clientName,
                                @QueryParam("clientNumber") String clientNumber,
                                @QueryParam("patientNumber") String patientNumber,
                                @QueryParam("cardNumber") String cardNumber,
                                @QueryParam("chipNumber") String chipNumber,
                                @QueryParam("specie") String specie,
                                @QueryParam("state") String state,
                                @Context ContainerRequest request) throws IOException {
        List<Patient> patients = new LinkedList<>();

        BVetPatientServices client = BVetClient.getClient(
                getBvetMiddlewareConfiguration().getBvetApiUrl(),
                user,
                BVetPatientServices.class
        );

        Call<List<Patient>> searchCall = client.search(patientName,clientName,clientNumber,patientNumber,cardNumber,chipNumber,specie,state);

        Response<List<Patient>> searchResponse = searchCall.execute();

        if(searchResponse.code() == 401){
            javax.ws.rs.core.Response response = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        if(searchResponse.code() == 200){
            patients = searchResponse.body();
            HateoasLink patientLink = HateoasLinkGenerator.get(request,String.format("%s/{id}",HateoasLinkInjector.BASE_PATH));
            if(patientLink != null){
                for(Patient patient : patients){
                    HateoasLink link = new HateoasLink(patientLink);
                    link.setHref(link.getHref().replace("{id}",patient.getId()));
                    patient.getLinks().add(link);
                }
            }
        }

        return patients;
    }

    private Hashtable<String,String> getBVetList(User user, String parameter, String text, String value) throws IOException {
        Hashtable<String,String> result = new Hashtable<>();

        BVetParametersServices client = BVetClient.getClient(
                getBvetMiddlewareConfiguration().getBvetApiUrl(),
                user,
                BVetParametersServices.class
        );

        Call<Hashtable<String,String>> listCall = client.list(parameter,text,value);
        Response<Hashtable<String,String>> listResponse = listCall.execute();

        if(listResponse.code() == 401){
            javax.ws.rs.core.Response response = javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.UNAUTHORIZED).build();
            throw new WebApplicationException(response);
        }

        if(listResponse.code() == 200){
            result = listResponse.body();
        }

        return result;
    }
}
