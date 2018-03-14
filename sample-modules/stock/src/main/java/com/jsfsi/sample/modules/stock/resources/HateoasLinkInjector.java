package com.jsfsi.sample.modules.stock.resources;

import com.jsfsi.sample.core.hateoas.HateoasLinkReference;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.extensibility.rest.HateoasRel;
import com.jsfsi.sample.extensibility.rest.HttpMethod;
import com.jsfsi.sample.modules.stock.Version;

public class HateoasLinkInjector {
    private static final String basePath = Version.NAME + Version.STOCK_PATH;

    private static HateoasLink filtersLink = new HateoasLink<>();

    public static void inject(){
        filtersLink.setMethod(HttpMethod.GET);
        filtersLink.setRel(HateoasRel.STOCK_FILTERS);
        filtersLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/filters",basePath),filtersLink);
    }

}
