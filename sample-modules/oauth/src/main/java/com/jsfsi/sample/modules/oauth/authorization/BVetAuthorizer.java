package com.jsfsi.sample.modules.oauth.authorization;

import com.jsfsi.sample.core.security.User;
import io.dropwizard.auth.Authorizer;

public class BVetAuthorizer implements Authorizer<User> {
    @Override
    public boolean authorize(User principal, String role) {
        //TODO: Implement rules
        return true;
    }
}
