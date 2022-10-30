package com.example.conyeu.fragment_nav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.conyeu.R;
import com.example.conyeu.create.createNhatKi_Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class nhatki_Fragment extends Fragment {


    FloatingActionButton btncreate;
    View view;
    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_nhatki_, container, false);
        btncreate=view.findViewById(R.id.btnCreate);
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag=new createNhatKi_Fragment();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,secondFrag);
                transaction.commit();


            }


        });

        return view;
    }


}