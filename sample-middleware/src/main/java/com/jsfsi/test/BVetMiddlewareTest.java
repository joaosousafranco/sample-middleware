package com.jsfsi.test;

import com.jsfsi.BVetMiddleware;
import com.jsfsi.lib.Async;

public class BVetMiddlewareTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void runTest() throws Exception {
        BVetMiddleware.main(new String[]{ "server", "build/libs/configuration.json"});

        Async.await(5);
    }
}
