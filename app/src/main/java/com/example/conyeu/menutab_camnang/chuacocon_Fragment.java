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
 * Use the {@link chuacocon_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chuacocon_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public chuacocon_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment chuacocon_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static chuacocon_Fragment newInstance(String param1, String param2) {
        chuacocon_Fragment fragment = new chuacocon_Fragment();
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
    private ArrayList<Camnang> camnang;
    private Camnang_Adapter camnangAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_chuacocon_, container, false);

        mRecyclerView=view.findViewById(R.id.rvhome);
        camnangAdapter = new Camnang_Adapter(getListUser(),view.getContext());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),3);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        mRecyclerView.setAdapter(camnangAdapter);










        return view;





    }
    private ArrayList<Camnang> getListUser(){
        ArrayList<Camnang> list=new ArrayList<>();
        list.add(new Camnang(1,R.drawable.ditruyen,"Di truyển và giới tính"));
        list.add(new Camnang(2,R.drawable.heart,"Tâm lý và sức khỏe"));
        list.add(new Camnang(3,R.drawable.nutrition,"Dinh dưỡng"));
        list.add(new Camnang(4,R.drawable.yoga,"Thay đổi thói quen"));

        return list;
    }
}