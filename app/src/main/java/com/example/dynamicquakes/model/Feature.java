package com.example.dynamicquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Feature {

    @SerializedName("properties")
    @Expose
    private Properties properties;


    public Feature(Properties properties) {
        this.properties = properties;

    }

    public Properties getProperties() {
        return properties;
    }


}
