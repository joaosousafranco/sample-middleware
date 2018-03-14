package com.jsfsi.sample.modules.localization.resources;

import com.jsfsi.sample.core.hateoas.HateoasLinkReference;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.extensibility.rest.HateoasRel;
import com.jsfsi.sample.extensibility.rest.HttpMethod;
import com.jsfsi.sample.modules.localization.Version;

public class HateoasLinkInjector {
    private static final String basePath = Version.NAME + Version.LOCALIZATION_PATH;

    private static HateoasLink localizationLink = new HateoasLink();

    public static void inject(){
        localizationLink.setMethod(HttpMethod.GET);
        localizationLink.setRel(HateoasRel.LOCALIZATION);

        HateoasLinkReference.inject(String.format("%s/{language}",basePath),localizationLink);
    }
}
