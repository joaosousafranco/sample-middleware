package com.jsfsi.sample.extensibility.rest;

import java.util.LinkedList;

public class HateoasLinkList extends LinkedList<HateoasLink> {
    @Override
    public boolean add(HateoasLink hateoasLink) {
        if(hateoasLink == null){
            return false;
        }

        return super.add(hateoasLink);
    }

    @Override
    public void add(int index, HateoasLink element) {
        if(element != null){
            super.add(index, element);
        }
    }

    @Override
    public void addFirst(HateoasLink hateoasLink) {
        if(hateoasLink != null){
            super.addFirst(hateoasLink);
        }
    }

    @Override
    public void addLast(HateoasLink hateoasLink) {
        if(hateoasLink != null){
            super.addLast(hateoasLink);
        }
    }

    public HateoasLink getLinkByRel(HateoasRel rel){
        HateoasLink resultLink = null;
        for(HateoasLink link : this){
            if(link != null && link.getRel() == rel){
                resultLink = link;
                break;
            }
        }
        return resultLink;
    }
}
