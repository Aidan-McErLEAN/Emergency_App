package com.example.firebaseapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    String all;

    public String getCloud() {
        return all;
    }

    public void setCloud(String temp) {
        this.all = temp;
    }
}
