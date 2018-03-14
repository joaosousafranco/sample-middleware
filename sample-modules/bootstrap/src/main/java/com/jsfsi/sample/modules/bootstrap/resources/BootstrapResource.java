package com.jsfsi.sample.modules.bootstrap.resources;

import com.jsfsi.sample.core.hateoas.HateoasLinkGenerator;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.extensibility.rest.LinkableResource;
import com.jsfsi.sample.modules.bootstrap.Version;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;
import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path(Version.NAME + Version.BOOTSTRAP_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class BootstrapResource extends DropwizardResource<DropwizardConfiguration> {

    @Override
    public void initialize() {

    }

    @GET
    @Path("/")
    public LinkableResource bootstrap(@Context ContainerRequest request){
        LinkableResource links = new LinkableResource();

        HateoasLink tokenLink = HateoasLinkGenerator.get(request,"/1.0/oauth2/token");
        HateoasLink localizationLink = HateoasLinkGenerator.get(request,"/1.0/localization/{language}");

        links.getLinks().add(tokenLink);
        links.getLinks().add(localizationLink);

        return links;
    }
}
