package com.example.firebaseapp.Retrofit;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    String speed;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String temp) {
        this.speed = temp;
    }

}
