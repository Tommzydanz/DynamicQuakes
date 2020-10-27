package com.example.dynamicquakes.services;

import com.example.dynamicquakes.model.QuakeModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface QuakeInterface {

    @GET("/earthquakes/feed/v1.0/summary/2.5_day.geojson")
    Call<QuakeModel> getQuakeFeatures();
}
