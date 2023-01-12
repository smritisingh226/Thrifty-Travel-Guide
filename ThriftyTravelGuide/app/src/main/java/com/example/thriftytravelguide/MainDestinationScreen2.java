//This is the first screen that the user sees after they successfully login.
//It shows all the destinations to the users using recycler view using card view.
//The user can select any destination to move further in the application.
package com.example.thriftytravelguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainDestinationScreen2 extends AppCompatActivity {
    //Creating an object for an array list to store the destinationModal array.
    ArrayList<destinationModal> arrDestination = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_destination_screen2);

        //Start a music service in the background of this activity.
        startService(new Intent(this, musicService.class));

        //Link layout files to java files.
        RecyclerView recyclerView = findViewById(R.id.destination);
        //Setting the layout(LinearLayout) for the recycler view using the setLayoutManager.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Adding elements in the arrayList using RecyclerDestinationAdapter class
        arrDestination.add(new destinationModal(R.drawable.canada, "CANADA"));
        arrDestination.add(new destinationModal(R.drawable.india,"INDIA"));
        arrDestination.add(new destinationModal(R.drawable.paris,"PARIS"));
        arrDestination.add(new destinationModal(R.drawable.australia, "AUSTRALIA"));

        //Creating an object for the adapter and setting it.
        RecyclerDestinationAdapter adapter = new RecyclerDestinationAdapter(this,arrDestination);
        recyclerView.setAdapter(adapter);

        
    }

//    //The metho
//    @Override
//    protected void onPause() {
//        super.onPause();
//        stopService(new Intent(this, musicService.class));
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        startService(new Intent(this, musicService.class));
//    }

    //When the app is killed the music in the background stops.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this, musicService.class));
    }


}