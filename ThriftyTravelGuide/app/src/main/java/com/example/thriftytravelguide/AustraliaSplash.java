//Splash Screen that directs the user to Australia activity
//This screen display the name of the destination along with a welcome message.
//Displays the screen for 3 seconds and automatically redirects you to the next activity
//Demonstrates the concept of threads and uses intent to pass to go to the login screen.

package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class AustraliaSplash extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia_splash);

        text = findViewById(R.id.secondactivity_australia);

        //Gets the intent from the previous activity to display the name of the destination
        text.setText(getIntent().getExtras().getString("destination_name"));

        //Uses handler() to delay the coming up of next screen by 3 secs.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Passes intent to display the next screen.
                Intent intent = new Intent(getApplicationContext(),australiaDescription.class);
                startActivity(intent);
            }
        }, 3000);
    }
}