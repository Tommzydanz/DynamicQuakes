package com.example.dynamicquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuakeModel {


    @SerializedName("features")
    @Expose
    private List<Feature> features;


    public QuakeModel(List<Feature> features) {
        this.features = features;
    }

    public List<Feature> getQuakeFeatures() {
        return features;
    }
}
