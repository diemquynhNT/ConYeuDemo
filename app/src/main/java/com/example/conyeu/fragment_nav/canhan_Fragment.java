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
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.conyeu.Adapter.BabyAdapter;
import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.AddeditBabyActivity;
import com.example.conyeu.DiaryActivity;
import com.example.conyeu.DiaryMainActivity;
import com.example.conyeu.R;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.bottomsheetdialog.InfoDialogBottomSheet;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class  canhan_Fragment extends Fragment  {

    private static final int RESULT_OK = -1;
    View view;
    FloatingActionButton btn_addbaby;

    private RecyclerView rcvbaby;
    private BabyAdapter mBabyAdapter;
    ArrayList<Baby> mListBaby;
    Baby baby;
    DBHelper dbHelper;

    //intent 3
    ActivityResultLauncher<Intent> mLauncherbb =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK) {
                        mListBaby = new ArrayList<>();
                        RefreshBaby();
//                        if (result.getData().getIntExtra("flag", 0) == 1) {
//                            mListBaby = new ArrayList<>();
//                            RefreshBaby();
//
//                        } else if(result.getData().getIntExtra("flag", 0) == 2){
//                            mListBaby = new ArrayList<>();
//                            RefreshBaby();
//                        } else if (result.getData().getIntExtra("flag", 0) == 3){
//                            mListBaby = new ArrayList<>();
//                            RefreshBaby();
//                        }
                    }
                }
            }
    );

//
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        view= inflater.inflate(R.layout.activity_baby, container, false);

        //add BABY
        btn_addbaby=view.findViewById(R.id.floatingActionButton_addbaby);
        btn_addbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), AddeditBabyActivity.class);
                intent.putExtra("BabyEdit", baby);
                intent.putExtra("flag",1);
                mLauncherbb.launch(intent);


            }
        });

        // do recyclerview
        rcvbaby=view.findViewById(R.id.rcv_listbaby);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this.getContext());
        rcvbaby.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL);
        rcvbaby.addItemDecoration(dividerItemDecoration);

        dbHelper = new DBHelper(this.getContext());
        mListBaby= new ArrayList<>();
        RefreshBaby();



        //do du lieu vao
//        mListBaby=new ArrayList<>();
//        mBabyAdapter=new BabyAdapter(mListBaby, this, new BabyAdapter.Listener() {
//            @Override
//            public void onItemBabyListener(Baby baby) {
//                onClickBabyListener(baby);
//            }
//        });


        rcvbaby.setAdapter(mBabyAdapter);


        return view;
    }

    private void onClickUpdateBaby(Baby babys) {
        InfoDialogBottomSheet infoDialogBottomSheet=new InfoDialogBottomSheet(this.getContext(),babys,mLauncherbb,mBabyAdapter);
        infoDialogBottomSheet.findView();
        infoDialogBottomSheet.show();
    }

    public void RefreshBaby(){
        ArrayList<Baby> data=dbHelper.getBaby();
        mListBaby.addAll(data);

        mBabyAdapter=new BabyAdapter(mListBaby, view.getContext(), new BabyAdapter.Listener() {
            @Override
            public void onItemBabyListener(Baby baby) {
                onClickUpdateBaby(baby);
            }
        });
        rcvbaby.setAdapter(mBabyAdapter);
    }

}