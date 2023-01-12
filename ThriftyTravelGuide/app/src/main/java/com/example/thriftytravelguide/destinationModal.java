//A model class to define the elemts that will be set in the recycler view

package com.example.thriftytravelguide;


public class destinationModal {
    //Declaration of variables
    int img;
    String destinationname;

    //Constructor to pass the fetch the variables that need to be set in  the recycler view.
    public destinationModal(int img, String destinationname){
        this.img = img;
        this.destinationname = destinationname;
    }
}
