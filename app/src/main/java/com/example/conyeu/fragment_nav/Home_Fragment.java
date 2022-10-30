package com.example.conyeu.fragment_nav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conyeu.R;
import com.example.conyeu.camnang.Camnang;
import com.example.conyeu.camnang.itemadapter;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {


    View view;
    RecyclerView mRecyclerView;
    itemadapter Itemadapter;
    Camnang itemhome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_, container, false);

        mRecyclerView = view.findViewById(R.id.rvhome);
        Itemadapter = new itemadapter(getListItem(), view.getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
//       camnangAdapter.setData(getListUser());
        mRecyclerView.setAdapter(Itemadapter);




        return view;
    }



    private ArrayList<Camnang> getListItem() {
        ArrayList<Camnang> list = new ArrayList<>();
        list.add(new Camnang(1, R.drawable.baby, "Thông tin của con"));
        list.add(new Camnang(2, R.drawable.handbook, "Cẩm nang"));
        list.add(new Camnang(3, R.drawable.mother, "Thông tin của mẹ"));
        list.add(new Camnang(4, R.drawable.schedule, "Lịch tiêm ngừa theo tháng"));
//

        return list;
    }
}