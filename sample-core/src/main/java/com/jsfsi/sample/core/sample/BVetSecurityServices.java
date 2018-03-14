package com.jsfsi.sample.core.sample;

import com.jsfsi.sample.core.security.User;
import com.jsfsi.sample.extensibility.user.OAuthCredentials;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BVetSecurityServices {
    @POST("security/authenticate")
    Call<String> authenticate(@Body OAuthCredentials credentials);

    @GET("security/info")
    Call<User> user();
}
