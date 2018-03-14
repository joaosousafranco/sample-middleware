package com.jsfsi.sample.extensibility.user;

import com.jsfsi.sample.extensibility.rest.LinkableResource;

import java.util.List;

public class User extends LinkableResource {
    private String name;
    private String email;
    private List<String> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
