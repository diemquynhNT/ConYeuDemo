package com.example.conyeu.fragment_nav;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.conyeu.R;


public class  canhan_Fragment extends Fragment {


    View view;

    Button btnupdate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_canhan_, container, false);

        btnupdate =view.findViewById(R.id.btn_update);



        return view;
    }
}