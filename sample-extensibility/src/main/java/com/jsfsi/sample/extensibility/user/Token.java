package com.jsfsi.sample.extensibility.user;

import com.jsfsi.sample.extensibility.BaseModel;
import com.jsfsi.sample.extensibility.rest.HateoasLinkList;

public class Token extends BaseModel {
    private String token;
    private TokenType type;
    private HateoasLinkList patient;
    private HateoasLinkList stock;
    private HateoasLinkList user;

    public Token() {
        patient = new HateoasLinkList();
        stock = new HateoasLinkList();
        user = new HateoasLinkList();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public HateoasLinkList getPatient() {
        return patient;
    }

    public void setPatient(HateoasLinkList patient) {
        this.patient = patient;
    }

    public HateoasLinkList getStock() {
        return stock;
    }

    public void setStock(HateoasLinkList stock) {
        this.stock = stock;
    }

    public HateoasLinkList getUser() {
        return user;
    }

    public void setUser(HateoasLinkList user) {
        this.user = user;
    }
}
