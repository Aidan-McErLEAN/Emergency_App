package com.example.firebaseapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("weather?appid=df79eeda58db5380ae6f6453911c55f7&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
