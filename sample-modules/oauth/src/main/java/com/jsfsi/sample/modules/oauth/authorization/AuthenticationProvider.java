package com.jsfsi.sample.modules.oauth.authorization;

import com.jsfsi.sample.core.security.User;
import com.jsfsi.lib.dropwizard.DropwizardAuthentication;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;

public class AuthenticationProvider extends DropwizardAuthentication {

    public AuthenticationProvider(){
        super(
                new OAuthCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new BVetAuthenticator())
                        .setAuthorizer(new BVetAuthorizer())
                        .setPrefix("Bearer")
                .buildAuthFilter()
        );
    }


}
