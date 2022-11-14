package com.example.conyeu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.fragment_nav.Home_Fragment;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DiaryMainActivity extends AppCompatActivity  {

    private RecyclerView rcvdiary;
    private DiaryAdapter mDiaryAdapter;
    private ArrayList<Diary> mListDiary;
    Button btnupdatediary,btncanceldiary;
    FloatingActionButton btnAdddiary;
    EditText ednewcontent,txtitlediary;

    DBHelper dbHelper;
    Diary diary;
    //intent 3
    ActivityResultLauncher<Intent> mLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK) {
                        if (result.getData().getIntExtra("flag", 0) == 1) {
                            mListDiary = new ArrayList<>();
                            RefreshDiary();

                        } else if(result.getData().getIntExtra("flag", 0) == 2){
                            mListDiary = new ArrayList<>();
                            RefreshDiary();
                        } else if (result.getData().getIntExtra("flag", 0) == 3){
                            mListDiary = new ArrayList<>();
                            RefreshDiary();
                       }
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Nhật kí của mẹ");

        // do recyclerview
        rcvdiary=findViewById(R.id.rcv_diary);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvdiary.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvdiary.addItemDecoration(dividerItemDecoration);

        //do du lieu vao
        dbHelper = new DBHelper(DiaryMainActivity.this);
        mListDiary= new ArrayList<>();


        ArrayList<Diary> data=dbHelper.getDiary();
        mListDiary.addAll(data);

        mDiaryAdapter =new DiaryAdapter(mListDiary, this, new DiaryAdapter.Listener() {
            @Override
            public void onClickListenerDiary(Diary diary) {
                onClickUpdateDiary(diary);
            }
        });
        rcvdiary.setAdapter(mDiaryAdapter);




        // btn them diary
        btnAdddiary=findViewById(R.id.btn_fladdDiary);
        btnAdddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiaryMainActivity.this,DiaryActivity.class);
                intent.putExtra("DiaryEdit", diary);
                intent.putExtra("flag",1);
                mLauncher.launch(intent);

            }
        });






    }
 /// click vao 1 diary
    private void onClickUpdateDiary(Diary diary) {
        Intent intent = new Intent(DiaryMainActivity.this,DiaryActivity.class);
        intent.putExtra("DiaryEdit", diary);
        intent.putExtra("flag",2);
        mLauncher.launch(intent);
    }




        @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return super.onSupportNavigateUp();
    }

    public void RefreshDiary(){
        ArrayList<Diary> data = dbHelper.getDiary();
        mListDiary.addAll(data);
        mDiaryAdapter =new DiaryAdapter(mListDiary, this, new DiaryAdapter.Listener() {
            @Override
            public void onClickListenerDiary(Diary diary) {
                onClickUpdateDiary(diary);
            }
        });
                rcvdiary.setAdapter(mDiaryAdapter);
    }





}