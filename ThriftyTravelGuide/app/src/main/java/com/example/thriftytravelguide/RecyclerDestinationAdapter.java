//This is the Adapter that acts as bridge between an AdapterView and the underlying data for that view.
//This provides access to the data items.
//It is also responsible for making a View for each item in the data set.
package com.example.thriftytravelguide;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// An adapter extending from RecyclerView.Adapter
public class RecyclerDestinationAdapter extends RecyclerView.Adapter<RecyclerDestinationAdapter.ViewHolder> {
    Context context;
    ArrayList<destinationModal> arrDestination;     // Store a member variable for the destinations

    // Pass in the destination array into the constructor
    RecyclerDestinationAdapter(Context context, ArrayList<destinationModal> arrDestination){
        this.context = context;
        this.arrDestination = arrDestination;
    }


    //Implementing the primary methods for the adapter i.e.
    //onCreateViewHolder, onBindViewHolder and getItemCount
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.destination_row,parent,false);
        //Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //Populate the data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Using the holder set item views to the layout
        holder.imgdestination.setImageResource(arrDestination.get(position).img);
        holder.txtdestination.setText(arrDestination.get(position).destinationname);
        String destination_position = arrDestination.get(position).destinationname;

        //On the click of a card generate a toast of the destination selected and
        //with the help of intents take the user to a new activity.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast giving information of the destination selected
                Toast.makeText(context,"Destination selected " + destination_position, Toast.LENGTH_LONG).show();

                //Passes the intents to different activities as oer user selection.
                Intent canada = new Intent(context, CanadaSplash.class);
                Intent india = new Intent(context, IndiaSplash.class);
                Intent paris = new Intent(context,ParisSplash.class);
                Intent australia = new Intent(context,AustraliaSplash.class);
                //Sets the background color of the card that the user has visited once to a different color
                holder.itemView.setBackgroundColor(Color.parseColor("#DE3163"));

                //Conditions that govern which activity the user will be directed to based on the
                // position of the card they selected.
                if (holder.getAdapterPosition() == 0){
                    canada.putExtra("destination_name", destination_position);
                    context.startActivity(canada);
                }
               else if(holder.getAdapterPosition() == 1){
                    india.putExtra("destination_name", destination_position);
                    context.startActivity(india);
               }
               else  if(holder.getAdapterPosition() == 2){
                   paris.putExtra("destination_name",destination_position);
                   context.startActivity(paris);
                }
               else if(holder.getAdapterPosition()==3){
                   australia.putExtra("destination_name",destination_position);
                   context.startActivity(australia);
                }
            }
        });
    }

    //Gets the size of the array in order to populate the recycler view.
    @Override
    public int getItemCount() {
        return arrDestination.size();
    }

    // Provide a direct reference to each of the views within a data item
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Defining all member variables for the view that will be set on each row
        TextView txtdestination;
        ImageView imgdestination;

        //Constructor that accepts the entire item row
        //Link layout files to java files.
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setBackgroundColor(R.drawable.appbackground);
            txtdestination = itemView.findViewById(R.id.destination_name);
            imgdestination = itemView.findViewById(R.id.destinationimage);

        }
    }
}
