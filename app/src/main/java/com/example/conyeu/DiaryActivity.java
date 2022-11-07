package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conyeu.object.Diary;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DiaryActivity extends AppCompatActivity {

   EditText edtcontent,edttitle,edid;
   Button btnAddDiary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        initUI();

        btnAddDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(edid.getText().toString().trim());
                String content=edtcontent.getText().toString().trim();
                String title=edttitle.getText().toString().trim();

                Diary diary= new Diary(id,title,content);
                onClickAtDiary(diary);
            }
        });


    }

    private void initUI(){
        edttitle=findViewById(R.id.edAddDiary);
        edtcontent=findViewById(R.id.edtAddcontent);
        btnAddDiary=findViewById(R.id.add_diary);
        edid=edttitle=findViewById(R.id.edt_id);


    }

    private void onClickAtDiary(Diary diary){

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("list_diary");

        String pathObject=String.valueOf(diary.getId());
        myRef.child(pathObject).setValue(diary, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(DiaryActivity.this,"Add succes",Toast.LENGTH_SHORT).show();
            }
        });
////        FirebaseDatabase database = FirebaseDatabase.getInstance();
////        DatabaseReference myRef = database.getReference("hello");
////
////        myRef.setValue("Hello, World!");
//
//
//
//
//
//
    }

}