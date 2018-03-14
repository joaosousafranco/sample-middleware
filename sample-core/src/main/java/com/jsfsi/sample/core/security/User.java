package com.jsfsi.sample.core.security;

import java.security.Principal;

public class User extends com.jsfsi.sample.extensibility.user.User implements Principal{
    private String cookie;

    public User() {
        super();
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

}
