//Fragment to show attractions in australia.
package com.example.thriftytravelguide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ausAttraction extends Fragment {

    public ausAttraction() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for ausAttraction
        return inflater.inflate(R.layout.fragment_aus_attraction, container, false);
    }
}