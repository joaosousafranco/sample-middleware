package com.jsfsi.sample.modules.localization.resources;

import com.jsfsi.sample.modules.localization.Version;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Hashtable;

@Path(Version.NAME + Version.LOCALIZATION_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class LocalizationResource extends DropwizardResource<DropwizardConfiguration> {
    @Override
    public void initialize() {
        HateoasLinkInjector.inject();
    }

    @GET
    @Path("/{language}")
    public Hashtable<String,String> localization(@PathParam("language") String language){
        Hashtable<String,String> strings = new Hashtable<>();

        strings.put("Key","Value-" + language);

        return strings;
    }
}
