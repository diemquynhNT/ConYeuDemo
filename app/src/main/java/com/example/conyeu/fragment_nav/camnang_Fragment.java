package com.example.conyeu.fragment_nav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.conyeu.R;
import com.example.conyeu.menutab_camnang.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link camnang_Fragment#newInstance} factory method to
// * create an instance of this fragment.
 */
public class camnang_Fragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public camnang_Fragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment camnang_Fragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static camnang_Fragment newInstance(String param1, String param2) {
//        camnang_Fragment fragment = new camnang_Fragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    //tabmenu

    private TabLayout menutab;
    private ViewPager menuViewpager;
    private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_camnang_, container, false);
        mView= inflater.inflate(R.layout.fragment_camnang_,container,false);

        menutab=mView.findViewById(R.id.tabmenu);
        menuViewpager=mView.findViewById(R.id.view_paper);
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
         menuViewpager.setAdapter(viewPageAdapter);
        menutab.setupWithViewPager(menuViewpager);

        return mView;
    }
}