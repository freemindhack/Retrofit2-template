package com.sadiq.msa.retrofit2example;

/**
 * Created by muhammadsadiqali on 06/02/16.
 */

import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

public interface Apiservice {

    @GET("curators.json")
    Call<Freemusicpojo> getDataset(@Query("api_key")  String api_key);

}

