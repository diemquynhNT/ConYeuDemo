package com.example.conyeu.menutab_camnang;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conyeu.R;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.Adapter.Camnang_Adapter;

import java.util.ArrayList;


public class camnangfavorite_Fragment extends Fragment {


    View view;

    private RecyclerView mRecyclerView;


    private ArrayList<Camnang> camnang;
    private Camnang_Adapter camnangAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_cn_favorite, container, false);


        return view;
    }



}