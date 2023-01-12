//Splash Screen for Home page.
//This screen display the welcome screen for the app.
//Displays the screen for 3 seconds and automatically redirects you to the login page.
//Demonstrates the concept of threads and uses intent to pass to go to the login screen.

package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Uses handler() to delay the coming up of next screen by 3 secs.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Passes intent to display the next screen.
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }, 3000);

    }
}