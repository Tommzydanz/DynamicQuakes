package com.example.dynamicquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Properties {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("mag")
    @Expose
    private int mag;

    @SerializedName("time")
    @Expose
    private int time;


    public Properties(String title, int mag, int time) {
        this.title = title;
        this.mag = mag;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public int getMag() {
        return mag;
    }

    public int getTime() {
        return time;
    }

}
