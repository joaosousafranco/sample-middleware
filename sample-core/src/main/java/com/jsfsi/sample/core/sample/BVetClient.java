package com.jsfsi.sample.core.sample;

import com.jsfsi.sample.core.security.User;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BVetClient {

    public static <T> T getClient(String baseUrl, Class<T> service){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        T client = retrofit.create(service);

        return client;
    }

    public static <T> T getClient(String baseUrl, User user, Class<T> service){
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(new AddCookiesInterceptor(user.getCookie()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpBuilder.build())
                .build();

        T client = retrofit.create(service);

        return client;
    }
}
