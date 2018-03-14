package com.jsfsi.sample.extensibility.user;

import com.jsfsi.sample.extensibility.BaseModel;

public class OAuthCredentials extends BaseModel {
    private String grant;
    private String username;
    private String password;

    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
