package com.jsfsi.sample.modules.oauth.authorization;

import com.jsfsi.sample.core.security.User;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.util.Hashtable;
import java.util.UUID;

// NOTES: https://github.com/remmelt/dropwizard-oauth2-provider/blob/master/src/main/java/com/remmelt/examples/auth/SimpleAuthenticator.java
// NOTES: https://dropwizard.github.io/dropwizard/0.9.1/docs/manual/auth.html

public class BVetAuthenticator implements Authenticator<String, User>  {

    public static Hashtable<UUID,User> tokens;

    static {
        tokens = new Hashtable<>();
    }

    @Override
    public java.util.Optional<User> authenticate(String accessTokenId) throws AuthenticationException {
        java.util.Optional<User> user = java.util.Optional.empty();

        // Check input, must be a valid UUID
        try {
            UUID accessTokenUUID = UUID.fromString(accessTokenId);

            if(tokens.containsKey(accessTokenUUID)){
                user = java.util.Optional.of(tokens.get(accessTokenUUID));
            }
        } catch (IllegalArgumentException e) {
        }

        return user;
    }
}
