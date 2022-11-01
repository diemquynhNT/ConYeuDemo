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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nuoicon_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nuoicon_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public nuoicon_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nuoicon_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static nuoicon_Fragment newInstance(String param1, String param2) {
        nuoicon_Fragment fragment = new nuoicon_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    View view;

    private RecyclerView mRecyclerView;
    //rivate RecyclerView.LayoutManager mLayoutManager;
    int a=3;

    private ArrayList<Camnang> camnang;
    private Camnang_Adapter camnangAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_nuoicon_, container, false);

        mRecyclerView=view.findViewById(R.id.rvNuoicon);
        camnangAdapter = new Camnang_Adapter(getListUser(),view.getContext());


        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mRecyclerView.setAdapter(camnangAdapter);
        return view;
    }

    private ArrayList<Camnang> getListUser(){
        ArrayList<Camnang> list=new ArrayList<>();
        list.add(new Camnang(1,R.drawable.baby1,"Trẻ sơ sinh"));
        list.add(new Camnang(2,R.drawable.tiem,"Tiêm phòng cho trẻ"));
        list.add(new Camnang(3,R.drawable.benh,"Bệnh trẻ em"));
        list.add(new Camnang(4,R.drawable.tuankhunghoang,"Tuần khủng hoảng"));
        list.add(new Camnang(5,R.drawable.treosinh,"An toàn cho bé"));
        list.add(new Camnang(6,R.drawable.dauhieu,"Dấu hiệu bất thường"));
        list.add(new Camnang(7,R.drawable.dungthuoc,"Dùng thuốc an toàn"));


        return list;
    }


}