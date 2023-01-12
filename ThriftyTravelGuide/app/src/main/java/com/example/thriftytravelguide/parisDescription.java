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

public class parisDescription extends AppCompatActivity {

    //Declaration of variables
    Button paweather, pamusttry, paattraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paris_description);

        //Link layout files to java files
        paweather = findViewById(R.id.paweather);
        paattraction = findViewById(R.id.paattraction);
        pamusttry = findViewById(R.id.pamusttry);

        //this is the default fragment that will be loaded the first time
        loadfrag(new paMustTry(), 0);

        //On the click of the different buttons present on the screen various fragments will be loaded
        //by calling the loadfragment method
        paweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new paweather(),1);
            }
        });

        pamusttry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new paMustTry(),1);
            }
        });

        paattraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadfrag(new paattraction(),1);
            }
        });
    }

    //Method to load the fragments on the activity
    public void loadfrag(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag == 0)
            ft.add(R.id.pacontainer, fragment);
        else
            ft.replace(R.id.pacontainer,fragment);

        ft.commit();
    }

}