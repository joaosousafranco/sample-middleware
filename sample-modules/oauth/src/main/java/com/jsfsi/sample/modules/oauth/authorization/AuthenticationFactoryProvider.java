package com.jsfsi.sample.modules.oauth.authorization;

import com.jsfsi.sample.core.security.User;
import com.jsfsi.lib.dropwizard.DropwizardAuthenticationFactory;

public class AuthenticationFactoryProvider extends DropwizardAuthenticationFactory<User>{
    public AuthenticationFactoryProvider() {
        super(User.class);
    }
}
