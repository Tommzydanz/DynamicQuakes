package com.example.dynamicquakes.services;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URL;
import java.security.cert.CertPathBuilder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuakeApiService {

    private static final String URL = "https://earthquake.usgs.gov/";

    private Retrofit retrofit;
    private static QuakeApiService quakeApiService;
    OkHttpClient.Builder okHttPClient;



    private QuakeApiService(){

        okHttPClient = new OkHttpClient.Builder().readTimeout(1000, TimeUnit.MINUTES);
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized QuakeApiService getInstance(){
        if(quakeApiService == null){
            quakeApiService = new QuakeApiService();
        }

        return  quakeApiService;
    }

    public QuakeInterface getApi(){
        return retrofit.create(QuakeInterface.class);
    }


}
