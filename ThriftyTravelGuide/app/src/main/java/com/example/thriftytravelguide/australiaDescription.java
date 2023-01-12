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
import android.widget.TextView;

public class australiaDescription extends AppCompatActivity {

    //Declaration of variables
    Button ausweather, ausattraction, ausmusttry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia_description);

        //Link layout files to java files
        ausweather= findViewById(R.id.ausweather);
        ausattraction = findViewById(R.id.ausattraction);
        ausmusttry = findViewById(R.id.ausmusttry);


        loafFrag(new ausMustTry(), 0);      //this is the default fragment that will be loaded the first time

        //On the click of the different buttons present on the screen various fragments will be loaded
        //by calling the loadfragment method
        ausweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new ausWeather(), 0);
            }
        });

        ausattraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new ausAttraction(),0);
            }
        });

        ausmusttry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loafFrag(new ausMustTry(),0);
            }
        });
    }

    //Method to load the fragments on the activity
    public void loafFrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0)
            ft.add(R.id.auscontainer,fragment);
        else if(flag==1)
            ft.replace(R.id.auscontainer,fragment);
        ft.commit();
    }
}