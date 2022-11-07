package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conyeu.object.Diary;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {

   EditText edtcontent,edttitle,eddate;
   Button btnAddDiary;
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
        String pathObject=String.valueOf(diary.getTitle());

        myRef.child(pathObject).setValue(diary, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(DiaryActivity.this,"Add succes",Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void onClickAtDiary(Diary diary){

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("list_diary");




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


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}