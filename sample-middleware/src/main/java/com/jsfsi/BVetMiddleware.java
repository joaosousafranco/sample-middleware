package com.jsfsi;

import com.jsfsi.lib.dropwizard.DropwizardApplication;

public class BVetMiddleware extends DropwizardApplication<Configuration> {
    private static BVetMiddleware server;

    public static void main(String[] args) throws Exception {
        server = new BVetMiddleware();

        server.run(args);
    }
}
