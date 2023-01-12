//This is the login activity.
//It asks the user to login or register if they are not already registered.
//If the user tries to login without registering, it will give you

package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaration of variables
    EditText email;
    EditText password;
    ImageButton login, register;

    SharedPreferences preferences;          //Object of SharedPreference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Link layout files to java files
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.sign_in);
        register = findViewById(R.id.sign_up);


        //Create shared sharedPreference in private mode with the same key as in register acivity
        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);

        //On the click of login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Getting values entered by the user and converting it to string
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();
                if(emailValue.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter a Valid Email",Toast.LENGTH_SHORT).show();
                }
                else if(passwordValue.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter a Valid Password",Toast.LENGTH_SHORT).show();
                }

                //getting the values from sharedpreferences for email and password in string format
                String registerEmail = preferences.getString("email", "");
                String registerPassword = preferences.getString("password", "");

                //Comparing the values of the user input versur that stored in the shared preferences
                //if the values match, lets the user login and directs it to the next screen using intent.
                //else displays a toast.
                if (emailValue.equals(registerEmail) && passwordValue.equals(registerPassword)) {
                    Intent intent = new Intent(getApplicationContext(), MainDestinationScreen2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Login. Please register", Toast.LENGTH_LONG).show();
                }
            }
        });

        //On the click of register button the user is redirected to a different activity for registration using intent
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }
}