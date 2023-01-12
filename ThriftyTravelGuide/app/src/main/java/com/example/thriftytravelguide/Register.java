//This is the Registeration activity.
//It asks the user to Register or press on Cancel to reset the fields.
//It checks for certain validations before the user is registered

package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //Declaration of variables
    EditText username, password, email, dob;
    ImageButton register, cancel;

    //Object of SharedPreference
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Link layout files to java files
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        //Create shared sharedPreference in private mode with a key
        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);

        //On the click of register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Getting values entered by the user and converting it to string
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String dobValue = dob.getText().toString();

                //Check if all the fields are filled
                if (!(usernameValue.isEmpty() ||dobValue.isEmpty() || emailValue.isEmpty() || passwordValue.length()>7)) {

                    //Save the values entered by the user in sharedPreference in key value pair
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("email", emailValue);
                    editor.putString("dob", dobValue);
                    editor.apply();

                    //If the values get stored give a toast that the user got registered else give an error toast
                    Toast.makeText(Register.this, "User Registered", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Register.this, "No fields can be left empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //On the click of cancel button call an empty field method.
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    emptyField();
                }

        });

    }

    //Declare an empty field method that resets all the fields to blank.
    public  void emptyField(){
        username.setText("");
        password.setText("");
        email.setText("");
        dob.setText("");
    }
}