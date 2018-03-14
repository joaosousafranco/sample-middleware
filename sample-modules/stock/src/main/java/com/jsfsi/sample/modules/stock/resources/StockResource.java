package com.jsfsi.sample.modules.stock.resources;

import com.jsfsi.sample.extensibility.rest.LinkableResource;
import com.jsfsi.sample.extensibility.user.User;
import com.jsfsi.sample.modules.stock.Version;
import com.jsfsi.lib.dropwizard.DropwizardConfiguration;
import com.jsfsi.lib.dropwizard.DropwizardResource;
import io.dropwizard.auth.Auth;
import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path(Version.NAME + Version.STOCK_PATH)
@Produces(MediaType.APPLICATION_JSON)
public class StockResource extends DropwizardResource<DropwizardConfiguration> {
    @Override
    public void initialize() {
        HateoasLinkInjector.inject();
    }

    @GET
    @Path("/filters")
    public LinkableResource filters(@Auth User user, @Context ContainerRequest request){
        LinkableResource links = new LinkableResource();

        return links;
    }
}
