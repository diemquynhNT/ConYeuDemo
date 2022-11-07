package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.conyeu.object.Diary;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {

    ArrayList<Diary> mLis;
   EditText edtcontent,edttitle,eddate;
   Button btnAddDiary;
   ImageButton btnbacktodiary;
    int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        edttitle=findViewById(R.id.edAddDiary);
        edtcontent=findViewById(R.id.edtAddcontent);

        eddate=findViewById(R.id.edt_datediary);
        eddate.setOnClickListener(view -> {
            if (view == eddate) {
                final Calendar calendar = Calendar.getInstance();
                mYear = calendar.get(Calendar.YEAR);

                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);

                //show dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(DiaryActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        eddate.setText(dayOfMonth + "/" + String.format("%02d", month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnbacktodiary=findViewById(R.id.imgbtn_todiary);
        btnbacktodiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiaryActivity.this,DiaryMainActivity.class);
                startActivity(intent);
            }
        });

        btnAddDiary=findViewById(R.id.add_diary);
        btnAddDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushdata();


            }
        });





    }

    private void pushdata() {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("list_diary");

        String title=edttitle.getText().toString();
        String content=edtcontent.getText().toString();
        String date=eddate.getText().toString();



        Diary diary=new Diary(title,content,date);
        //dat ten nhanh cha
        String pathObject=String.valueOf(diary.getTitle());

        myRef.child(pathObject).setValue(diary, new DatabaseReference.CompletionListener() {
            //thong bao khi nhap thanh cong
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(DiaryActivity.this,"Nhật kí đã được thêm thành công",Toast.LENGTH_SHORT).show();
            }
        });


    }





}