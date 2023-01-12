//This is the main activity for australia destination that displays fragments .
//It has three fragments that display different information on the same activity.
package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class canadaDescription extends AppCompatActivity {

    //Declaration of variables
    Button caweather, caattraction, camusttry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canada_description);

        //Link layout files to java files
        caweather= findViewById(R.id.caweather);
        caattraction = findViewById(R.id.caattraction);
        camusttry = findViewById(R.id.camusttry);


        loafFrag(new caMustTry(), 0);      //this is the default fragment that will be loaded the first time

        //On the click of the different buttons present on the screen various fragments will be loaded
        //by calling the loadfragment method
        caweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new caWeather(), 1);
            }
        });

        caattraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new caAttraction(), 1);
            }
        });

        camusttry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new caMustTry(), 1);
            }
        });
    }

    //Method to load the fragments on the activity
    public void loafFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag == 0)
            ft.add(R.id.cacontainer,fragment);
        else
            ft.replace(R.id.cacontainer, fragment);
        ft.commit();
    }
}