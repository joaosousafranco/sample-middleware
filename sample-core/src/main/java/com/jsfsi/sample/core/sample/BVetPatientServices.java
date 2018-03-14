package com.jsfsi.sample.core.sample;

import com.jsfsi.sample.extensibility.patient.Patient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface BVetPatientServices {
    @GET("patient/search")
    Call<List<Patient>> search(@Query("patientName") String patientName, @Query("clientName") String clientName, @Query("clientNumber") String clientNumber, @Query("patientNumber") String patientNumber, @Query("cardNumber") String cardNumber, @Query("chipNumber") String chipNumber, @Query("specie") String specie, @Query("state") String state);

    @GET("patient/detail/{id}")
    Call<Patient> detail(@Path("id") String id);
}
