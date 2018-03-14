package com.jsfsi.sample.extensibility.rest;

import com.jsfsi.sample.extensibility.BaseModel;

public class LinkableResource extends BaseModel {
    private HateoasLinkList links;

    public HateoasLinkList getLinks() {
        if(links == null){
            links = new HateoasLinkList();
        }
        return links;
    }

    public void setLinks(HateoasLinkList links) {
        this.links = links;
    }
}
