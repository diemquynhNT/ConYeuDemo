package com.example.conyeu.create;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.conyeu.R;
import com.example.conyeu.calendar_Activity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class createcalendar_Activity extends AppCompatActivity {
//
    ImageButton btnbacktocanlender;
    TextInputEditText editDay;
    int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcalendar);

        btnbacktocanlender=findViewById(R.id.btnBacktocalendar);
        btnbacktocanlender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent=new Intent(createcalendar_Activity.this, calendar_Activity.class);
                //intent.putExtra("flag",1);
                startActivity(intent);
            }
        });

        editDay=findViewById(R.id.edDay);
        editDay.setOnClickListener(view -> {
            if (view == editDay) {
                final Calendar calendar = Calendar.getInstance ();
                mYear = calendar.get ( Calendar.YEAR );
                mMonth = calendar.get ( Calendar.MONTH );
                mDay = calendar.get ( Calendar.DAY_OF_MONTH );

                //show dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog ( createcalendar_Activity.this, new DatePickerDialog.OnDateSetListener () {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        editDay.setText ( dayOfMonth + "/" + String.format("%02d",month+1) + "/" + year );
                    }
                }, mYear, mMonth, mDay );
                datePickerDialog.show ();
            }
        });




    }}

//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return super.onSupportNavigateUp();
//    }
//}

