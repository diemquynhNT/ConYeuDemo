package com.example.conyeu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DiaryMainActivity extends AppCompatActivity {

//    private RecyclerView rcvdiary;
//    private DiaryAdapter mDiaryAdapter;
//    private ArrayList<Diary> mListDiary;
//    FloatingActionButton btnAdddiary;

//    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == RESULT_OK) {
//                        if (result.getData().getIntExtra("flag", 0) == 1) {
//                            Phone phones = (Phone) result.getData().getSerializableExtra("contact");
//                            phoneAdapter.addContact(phones);
//                        }
//                    }
//                }
//            }
//    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

//        rcvdiary=findViewById(R.id.rcv_diary);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        rcvdiary.setLayoutManager(linearLayoutManager);
//
//        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        rcvdiary.addItemDecoration(dividerItemDecoration);
//
//        mListDiary=new ArrayList<>();
//        mDiaryAdapter =new DiaryAdapter(mListDiary);
//        rcvdiary.setAdapter(mDiaryAdapter);
//
//        getListDiaryDB();
//
//        btnAdddiary=findViewById(R.id.btn_fladdDiary);
//        btnAdddiary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(DiaryMainActivity.this,DiaryActivity.class);
//                startActivity(intent);
//            }
//        });


    }

//    private void getListDiaryDB(){
//        FirebaseDatabase database=FirebaseDatabase.getInstance();
//        DatabaseReference myRef =database.getReference("list_diary");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot:snapshot.getChildren())
//                {
//                    Diary diary=dataSnapshot.getValue(Diary.class);
//                    mListDiary.add(diary);
//                }
//                mDiaryAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }



}