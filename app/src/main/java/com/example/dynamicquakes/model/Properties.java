package com.example.dynamicquakes.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Properties {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("mag")
        @Expose
        private double mag;

        @SerializedName("time")
        @Expose
        private long time;

        @SerializedName("url")
        @Expose
        private String url;




        @SerializedName("status")
        @Expose
        private String status;


        public Properties(String title, double mag, long time, String url, String status) {
            this.title = title;
            this.mag = mag;
            this.time = time;
            this.url = url;
            this.status = status;
        }





        public String getTitle() {
            return title;
        }

        public double getMag() {
            return mag;
        }

        public void setMag(double mag) {
            this.mag = mag;
        }
        public String getMagAsString(){
            return Double.toString(this.mag);
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;

        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getStatus() {
            return status;
        }
}
