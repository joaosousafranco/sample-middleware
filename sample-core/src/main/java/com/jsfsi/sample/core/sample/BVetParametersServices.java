package com.jsfsi.sample.core.sample;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;
import java.util.Hashtable;

public interface BVetParametersServices {
    @GET("parameters/list")
    Call<Hashtable<String,String>> list(@Query("parameter") String parameter, @Query("text") String text, @Query("value") String value);
}
