package com.example.conyeu.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conyeu.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class calendar_Fragment extends Fragment {



    View view;
    FloatingActionButton btnCalendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_calendar_, container, false);



        return view;



    }
}