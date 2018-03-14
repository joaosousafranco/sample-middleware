package com.jsfsi.sample.extensibility.rest;

import com.jsfsi.sample.extensibility.BaseModel;

public class HateoasLink<Body> extends BaseModel {
    private String href;
    private HttpMethod method;
    private HateoasRel rel;

    private boolean requiresAuthentication;
    private Body body;

    public HateoasLink(HateoasLink<Body> hateoasLink) {
        this.href = hateoasLink.href;
        this.method = hateoasLink.method;
        this.rel = hateoasLink.rel;
        this.requiresAuthentication = hateoasLink.requiresAuthentication;
        this.body = hateoasLink.body;
    }

    public HateoasLink() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public HateoasRel getRel() {
        return rel;
    }

    public void setRel(HateoasRel rel) {
        this.rel = rel;
    }

    public boolean isRequiresAuthentication() {
        return requiresAuthentication;
    }

    public void setRequiresAuthentication(boolean requiresAuthentication) {
        this.requiresAuthentication = requiresAuthentication;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
