package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firebaseapp.Retrofit.ApiClient;
import com.example.firebaseapp.Retrofit.ApiInterface;
import com.example.firebaseapp.Retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Weather extends AppCompatActivity {

    ImageView search, cloudimg, tempimg, windimg;
    TextView mainwindText, maintempText, mainrainText, subwindText, subtempText, subrainText;
    EditText textField;

    String  temp, wind, cloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        cloudimg = findViewById(R.id.cloudimg);
        tempimg = findViewById(R.id.tempimg);
        windimg = findViewById(R.id.windimg);
        search = findViewById(R.id.search);
        textField = findViewById(R.id.textField);

        mainrainText = findViewById(R.id.mainrainText);
        subrainText = findViewById(R.id.subrainText);

        maintempText = findViewById(R.id.maintempText);
        subtempText = findViewById(R.id.subtempText);

        mainwindText = findViewById(R.id.mainwindText);
        subwindText = findViewById(R.id.subwindText);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWeaherData(textField.getText().toString().trim());

            }
        });
    }

    private void getWeaherData(String name){

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                cloud = response.body().getCloud().getCloud();
                double cloudnum = Double.parseDouble(cloud);

                wind = response.body().getWind().getSpeed();
                double windnum = Double.parseDouble(wind);
                windnum = windnum * 14;

                temp = response.body().getMain().getTemp();
                double tempnum = Double.parseDouble(temp);

                subtempText.setText("Temperature: " + response.body().getMain().getTemp() + "°C");
                subwindText.setText("Wind: " + windnum + "mph");

                if (windnum >= 45) {
                    windimg.setImageResource(R.drawable.warnwind);
                } else {
                    windimg.setImageResource(R.drawable.windimg);
                }

                if (cloudnum >= 85) {
                    subrainText.setText("Heavy Rain");
                    cloudimg.setImageResource(R.drawable.warncloud);
                } else if (cloudnum >= 40) {
                    subrainText.setText("Light Rain");
                    cloudimg.setImageResource(R.drawable.cloudimg);
                } else if (cloudnum >= 20) {
                    subrainText.setText("Cloudy");
                    cloudimg.setImageResource(R.drawable.cloudimg);
                } else {
                    subrainText.setText("Sunny");
                    cloudimg.setImageResource(R.drawable.cloudimg);
                }

                //Temperature IF statement
                if (tempnum <= 0) {
                    tempimg.setImageResource(R.drawable.warntemp);
                } else {
                    tempimg.setImageResource(R.drawable.tempimg);
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
            }
        });
    }
}