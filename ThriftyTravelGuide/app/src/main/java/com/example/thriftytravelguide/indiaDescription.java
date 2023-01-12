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
import android.widget.Toast;

public class indiaDescription extends AppCompatActivity {

    //Declaration of variables
    Button inweather, inmusttry, inattraction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_description);

        //Link layout files to java files
        inweather = findViewById(R.id.inweather);
        inattraction = findViewById(R.id.inattraction);
        inmusttry = findViewById(R.id.inmusttry);


        //this is the default fragment that will be loaded the first time
        loadfraga(new inMustTry(), 0);

        //On the click of the different buttons present on the screen various fragments will be loaded
        //by calling the loadfragment method
        inweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfraga(new inweather(),1);
            }
        });

        inattraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfraga(new inattraction(),1);
            }
        });

        inmusttry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfraga(new inMustTry(), 1);
            }
        });
    }

    //Method to load the fragments on the activity
    public void loadfraga(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==0)
            ft.add(R.id.incontainer,fragment);
        else
            ft.replace(R.id.incontainer,fragment);
        ft.commit();

    }
}