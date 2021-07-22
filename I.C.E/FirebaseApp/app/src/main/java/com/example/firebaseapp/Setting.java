package com.example.firebaseapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;

public class Setting extends AppCompatActivity {
    private Firebase mRef;
    EditText edit_name1, edit_phone1, edit_name2, edit_phone2, edit_name3, edit_phone3, edit_name4, edit_phone4;
    Button btn_add1, btn_add2, btn_add3, btn_add4, btn_remove1, btn_remove2, btn_remove3, btn_remove4;
    String name = "";
    String phone = "";
    String nothing = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        Firebase.setAndroidContext(this);

        mRef = new Firebase("https://fir-75cdd-default-rtdb.firebaseio.com/");

        //BUTTONS
        btn_add1 = (Button) findViewById(R.id.button_add1);
        btn_add2 = (Button) findViewById(R.id.button_add2);
        btn_add3 = (Button) findViewById(R.id.button_add3);
        btn_add4 = (Button) findViewById(R.id.button_add4);
        btn_remove1 = (Button) findViewById(R.id.button_remove1);
        btn_remove2 = (Button) findViewById(R.id.button_remove2);
        btn_remove3 = (Button) findViewById(R.id.button_remove3);
        btn_remove4 = (Button) findViewById(R.id.button_remove4);

        //EDIT TEXTS
        edit_name1 = (EditText) findViewById(R.id.edit_name1);
        edit_phone1= (EditText) findViewById(R.id.edit_phone1);
        edit_name2 = (EditText) findViewById(R.id.edit_name2);
        edit_phone2 = (EditText) findViewById(R.id.edit_phone2);
        edit_name3 = (EditText) findViewById(R.id.edit_name3);
        edit_phone3 = (EditText) findViewById(R.id.edit_phone3);
        edit_name4 = (EditText) findViewById(R.id.edit_name4);
        edit_phone4 = (EditText) findViewById(R.id.edit_phone4);


        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME1 = mRef.child("NAME1");
                name = edit_name1.getText().toString();
                NAME1.setValue(name);

                Firebase PHONE1 = mRef.child("PHONE1");
                phone = edit_phone1.getText().toString();
                PHONE1.setValue(phone);
            }
        });

        btn_remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME1 = mRef.child("NAME1");
                NAME1.setValue(nothing);

                Firebase PHONE1 = mRef.child("PHONE1");
                PHONE1.setValue("0");
            }
        });


        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME2 = mRef.child("NAME2");
                name = edit_name2.getText().toString();
                NAME2.setValue(name);

                Firebase PHONE2 = mRef.child("PHONE2");
                phone = edit_phone2.getText().toString();
                PHONE2.setValue(phone);
            }
        });

        btn_remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME2 = mRef.child("NAME2");
                NAME2.setValue(nothing);

                Firebase PHONE2 = mRef.child("PHONE2");
                PHONE2.setValue("0");
            }
        });


        btn_add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME3 = mRef.child("NAME3");
                name = edit_name3.getText().toString();
                NAME3.setValue(name);

                Firebase PHONE3 = mRef.child("PHONE3");
                phone = edit_phone3.getText().toString();
                PHONE3.setValue(phone);
            }
        });

        btn_remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME3 = mRef.child("NAME3");
                NAME3.setValue(nothing);

                Firebase PHONE3 = mRef.child("PHONE3");
                PHONE3.setValue("0");
            }
        });

        btn_add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME4 = mRef.child("NAME4");
                name = edit_name4.getText().toString();
                NAME4.setValue(name);

                Firebase PHONE4 = mRef.child("PHONE4");
                phone = edit_phone4.getText().toString();
                PHONE4.setValue(phone);
            }
        });

        btn_remove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View view) {
                Firebase NAME4 = mRef.child("NAME4");
                NAME4.setValue(nothing);

                Firebase PHONE4 = mRef.child("PHONE4");
                PHONE4.setValue("0");
            }
        });
    }
}

