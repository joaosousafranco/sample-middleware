package com.jsfsi.sample.core.hateoas;

import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.lib.Strings;
import org.glassfish.jersey.server.ContainerRequest;

public class HateoasLinkGenerator {
    public static HateoasLink get(ContainerRequest request, String path){
        HateoasLink link = HateoasLinkReference.fetch(path);
        HateoasLink tempLink = null;

        if(link != null){
            tempLink = new HateoasLink(link);

            String parsedPath = Strings.isNullOrEmpty(tempLink.getHref()) ?
                    path :
                    tempLink.getHref();

            parsedPath = parsedPath.startsWith("/") ?
                    parsedPath.substring(1,parsedPath.length()) :
                    parsedPath;

            tempLink.setHref(request.getBaseUri() + parsedPath);
        }

        return tempLink;
    }
}
