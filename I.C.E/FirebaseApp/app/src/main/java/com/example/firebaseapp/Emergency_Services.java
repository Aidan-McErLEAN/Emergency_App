package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Emergency_Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_services);
    }

    private boolean checkPermission(String permission) {
        int permissionCheck =
                ContextCompat.checkSelfPermission(this, permission);
        return (permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    public void firenumber (View view) {
        String number = "999";
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + number));
            startActivity(intent);
        }
    }

    public void medicnumber (View view) {
        String number = "999";
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + number));
            startActivity(intent);
        }
    }

    public void policenumber (View view) {
        String number = "0800 555 111";
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + number));
            startActivity(intent);
        }
    }

    public void carnumber (View view) {
        String number = "0800 269 015";
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + number));
            startActivity(intent);
        }
    }
}