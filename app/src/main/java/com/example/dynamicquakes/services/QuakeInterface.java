package com.example.dynamicquakes.services;

import com.example.dynamicquakes.model.QuakeModel;


import retrofit2.Call;
import retrofit2.http.GET;

public interface QuakeInterface {

    @GET("summary/2.5_day.geojson")
    Call<QuakeModel> getQuakeFeatures();
}
