package com.jsfsi.sample.core.hateoas;

import com.jsfsi.sample.extensibility.rest.HateoasLink;

import java.util.Hashtable;

public class HateoasLinkReference {
    private static Hashtable<String,HateoasLink> references;

    static {
        references = new Hashtable<>();
    }

    public static HateoasLink fetch(String path){
        return references.get(path);
    }

    public static <T> void inject(String path, HateoasLink<T> link){
        references.put(path,link);
    }

}
