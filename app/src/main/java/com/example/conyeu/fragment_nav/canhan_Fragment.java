package com.example.conyeu.fragment_nav;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conyeu.Adapter.BabyAdapter;
import com.example.conyeu.InfoDialogBottomSheet;
import com.example.conyeu.R;
import com.example.conyeu.object.Baby;

import java.util.ArrayList;


public class  canhan_Fragment extends Fragment implements BabyAdapter.Listener {


    private static final int RESULT_OK =-1 ;
    View view;
    RecyclerView mRecyclerView;
    BabyAdapter babyAdapter;
    Baby baby;

    private ImageView imgavatar;
    TextView txnameuser,txemail,txnumberp;


    Button btnupdateUser,btnaddbaby;
    int pos;
//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_canhan_, container, false);
        //anh xa
        imgavatar=view.findViewById(R.id.imgAvatar);
        txnameuser=view.findViewById(R.id.txnamelogin);
        txemail=view.findViewById(R.id.txmail);
        txnumberp=view.findViewById(R.id.txphone);

        //do list
        mRecyclerView=view.findViewById(R.id.rvlistbaby);
        babyAdapter = new BabyAdapter(getListUser(),this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(babyAdapter);


        //su kien update thong tin User






        btnaddbaby=view.findViewById(R.id.btn_addbaby);
        btnaddbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(getContext(), AddeditBabyActivity.class);
////                Bundle bundle=new Bundle();
////                bundle.putSerializable("object_user",cn);
////                intent.putExtras(bundle);
//                startActivity(intent);
//
            }
        });



        return view;
    }
    private ArrayList<Baby> getListUser(){
        ArrayList<Baby> list=new ArrayList<>();
        list.add(new Baby(1,"nam","bo",20,1,"1/1/2002"));
        list.add(new Baby(2,"nam","bo",20,1,"1/1/2002"));
        list.add(new Baby(3,"nam","bo",20,1,"1/1/2002"));


        return list;
    }
    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            Baby babys = (Baby) result.getData().getSerializableExtra("contact");
                            babyAdapter.addBaby(babys);
                        } else {
                            Baby babys = (Baby) result.getData().getSerializableExtra("contact");
                            babyAdapter.editBaby(babys, pos);
                        }
                    }
                }
            }
    );


    @Override
    public void onItemListener(Baby p) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//        builder.setTitle("Contact");
//        builder.setMessage(baby.getNamebaby());
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();

        InfoDialogBottomSheet dialog = new InfoDialogBottomSheet(this.getContext(),mLauncher,p,babyAdapter);
        dialog.findView();
        dialog.show();
    }
//




}