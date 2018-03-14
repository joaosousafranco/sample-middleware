package com.jsfsi.sample.core.sample;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AddCookiesInterceptor implements Interceptor {

    private String cookie;

    public AddCookiesInterceptor(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie", cookie);

        return chain.proceed(builder.build());
    }
}
