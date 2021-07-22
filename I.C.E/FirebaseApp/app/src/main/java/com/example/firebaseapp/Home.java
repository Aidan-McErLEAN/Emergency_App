package com.example.firebaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Emergency_Services();
        Weather();
        AccountMagement();
        Map();
        Emergency_Contacts();
        Settings();
    }

    public void Emergency_Services() {
        Button Weather = (Button) findViewById(R.id.buttonES);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Emergency_Services.class));
            }
        });
    }

    public void Weather() {
        Button Weather = (Button) findViewById(R.id.buttonW);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Weather.class));
            }
        });
    }

    public void AccountMagement() {
        Button Weather = (Button) findViewById(R.id.buttonA);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Account.class));
            }
        });
    }

    public void Map() {
        Button Weather = (Button) findViewById(R.id.buttonYL);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, MapsActivity.class));
            }
        });
    }

    public void Emergency_Contacts() {
        Button Weather = (Button) findViewById(R.id.buttonEC);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Emergency_Contacts.class));
            }
        });
    }

    public void Settings() {
        Button Weather = (Button) findViewById(R.id.buttonS);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Setting.class));
            }
        });
    }
}
