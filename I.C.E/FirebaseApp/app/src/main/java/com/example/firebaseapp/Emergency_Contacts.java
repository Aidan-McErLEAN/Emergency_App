package com.example.firebaseapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class Emergency_Contacts extends AppCompatActivity {

    TextView title1, title2, title3, title4;
    String phone1, phone2, phone3, phone4;

    private Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_contacts);

        mRef = new Firebase("https://fir-75cdd-default-rtdb.firebaseio.com/");

        title1 = (TextView) findViewById(R.id.txt_contact1);
        title2 = (TextView) findViewById(R.id.txt_contact2);
        title3 = (TextView) findViewById(R.id.txt_contact3);
        title4 = (TextView) findViewById(R.id.txt_contact4);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String name1 = map.get("NAME1");
                String name2 = map.get("NAME2");
                String name3 = map.get("NAME3");
                String name4 = map.get("NAME4");
                title1.setText(name1);
                title2.setText(name2);
                title3.setText(name3);
                title4.setText(name4);

                phone1 = map.get("PHONE1");
                phone2 = map.get("PHONE2");
                phone3 = map.get("PHONE3");
                phone4 = map.get("PHONE4");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private boolean checkPermission(String permission) {
        int permissionCheck =
                ContextCompat.checkSelfPermission(this, permission);
        return (permissionCheck == PackageManager.PERMISSION_GRANTED);
    }

    public void NUMBER1 (View view) {
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + phone1));
            startActivity(intent);
        }
    }

    public void NUMBER2 (View view) {
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + phone2));
            startActivity(intent);
        }
    }

    public void NUMBER3 (View view) {
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + phone3));
            startActivity(intent);
        }
    }

    public void NUMBER4 (View view) {
        if (checkPermission("android.permission.CALL_PHONE") == false) {
            Toast toast = Toast.makeText(this, "You do not have the permissions.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel: " + phone4));
            startActivity(intent);
        }
    }
}
