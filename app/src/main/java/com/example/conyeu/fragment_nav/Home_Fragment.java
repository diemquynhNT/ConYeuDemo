package com.example.conyeu.fragment_nav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conyeu.R;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.Adapter.itemadapter;
import com.example.conyeu.object.ItemFunction;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {


    View view;
    RecyclerView mRecyclerView;
    itemadapter adapteritem;
    ItemFunction item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_, container, false);

        mRecyclerView = view.findViewById(R.id.rvchuacocon);
        adapteritem = new itemadapter(getListItem(), view.getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
//       camnangAdapter.setData(getListUser());
        mRecyclerView.setAdapter(adapteritem);




        return view;
    }



    private ArrayList<ItemFunction> getListItem() {
        ArrayList<ItemFunction> list = new ArrayList<>();
        list.add(new ItemFunction(1,R.drawable.notebook, "Cẩm nang"));
        list.add(new ItemFunction(2, R.drawable.notebook, "Nhật kí"));
        list.add(new ItemFunction(3, R.drawable.baby, "Thông tin của con"));
        list.add(new ItemFunction(4, R.drawable.schedule, "Lịch tiêm ngừa theo tháng"));
//

        return list;
    }
}