package com.example.conyeu.create;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.conyeu.R;
import com.example.conyeu.fragment_nav.nhatki_Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link createNhatKi_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class createNhatKi_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public createNhatKi_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment createNhatKi_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static createNhatKi_Fragment newInstance(String param1, String param2) {
        createNhatKi_Fragment fragment = new createNhatKi_Fragment();
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
    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_create_nhat_ki_, container, false);
        img=view.findViewById(R.id.imgback);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment secondFrag=new nhatki_Fragment();
                FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame,secondFrag);
                transaction.commit();
//

            }


        });

        return view;
    }
}