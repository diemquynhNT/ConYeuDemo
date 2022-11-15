package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Calendar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Random;

public class AddeditCalendarActivity extends AppCompatActivity {


    ArrayList<Calendar> mListCalendar;
    Button btnAdd;
    TextInputLayout tilTitle, tilAddress, tilNote, tilTime, tilDay;
    TextInputEditText edTitle, edAddress, edNote, edTime, edDay;
    int mYear, mMonth, mDay;
    int mHour, mMinute;
    int flag;
    Calendar calendar;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcalendar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        edTitle = findViewById(R.id.edt_namebabybmi);
        edAddress = findViewById(R.id.edt_address);
        edNote = findViewById(R.id.edt_note);
        edTime = findViewById(R.id.edTimecalendar);
        edTime.setOnClickListener(view -> {
            final java.util.Calendar calendar = java.util.Calendar.getInstance();
            mHour = calendar.get(java.util.Calendar.HOUR);
            mMinute = calendar.get(java.util.Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AddeditCalendarActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    edTime.setText(hourOfDay + ":" + String.format("%02d", minute));
                }
            }, mHour, mMinute, true);
            timePickerDialog.show();
        });

        edDay = findViewById(R.id.edDaycalendar);
        edDay.setOnClickListener(view -> {
            if (view == edDay) {
                final java.util.Calendar calendar = java.util.Calendar.getInstance();
                mYear = calendar.get(java.util.Calendar.YEAR);
                mMonth = calendar.get(java.util.Calendar.MONTH);
                mDay = calendar.get(java.util.Calendar.DAY_OF_MONTH);

                //show dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddeditCalendarActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        edDay.setText(dayOfMonth + "/" + String.format("%02d", month + 1) + "/" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                datePickerDialog.show();
            }
        });

        // xu ly ten khi flag truyen den
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if(flag == 1){
            getSupportActionBar().setTitle("Thêm lịch nhắc");

        }else {
            getSupportActionBar().setTitle("Thông tin lịch");
            calendar = (Calendar) intent.getSerializableExtra("CalendarEdit");
//            hien thi thong tin da nhap
            edTitle.setText(calendar.getTitle());
            edAddress.setText(calendar.getAddress());
            edNote.setText(calendar.getNote());
            edTime.setText(calendar.getTime());
            edDay.setText(calendar.getDate());

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_option,menu);
        if(flag==1)
        {
            MenuItem mndel=menu.findItem(R.id.mnDel);
            mndel.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.mnSave)
        {
            if(edTime.getText().toString().isEmpty()||
                    edAddress.getText().toString().isEmpty()||
                    edDay.getText().toString().isEmpty()||
            edTime.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Nhập nội dung trước khi lưu", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if(flag==1)
            {

                Calendar calendars= new Calendar(new Random().nextInt(9999),
                        edTitle.getText().toString().trim(),
                        edAddress.getText().toString().trim(),
                        edNote.getText().toString().trim(),
                        edTime.getText().toString().trim(),
                        edDay.getText().toString().trim());

                dbHelper=new DBHelper(AddeditCalendarActivity.this);
                dbHelper.insertCalendar(calendars);
                Intent intent = new Intent();
                intent.putExtra("flag",1);
                setResult(RESULT_OK,intent);
                finish();


                Notification notification=new Notification.Builder(this)
                .setContentText("lên")
                        .build();
            }
            else
            {
                Calendar calendars= new Calendar(calendar.getId(),
                        edTitle.getText().toString().trim(),
                        edAddress.getText().toString().trim(),
                        edNote.getText().toString().trim(),
                        edTime.getText().toString().trim(),
                        edDay.getText().toString().trim());

                dbHelper=new DBHelper(AddeditCalendarActivity.this);
                dbHelper.updateCalendar(calendars);
                Intent intent = new Intent();
                intent.putExtra("flag",2);
                setResult(RESULT_OK,intent);
                finish();
            }
        }
        else if(id==R.id.mnDel)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddeditCalendarActivity.this);
            builder.setTitle("Con");
            builder.setMessage("Bạn có muốn xóa ".concat(edTitle.getText().toString().trim()).concat("?"));
            builder.setNegativeButton("No",(dialog, i) ->{
                dialog.cancel();
            } );
            builder.setPositiveButton("Yes",(dialog, i) ->{
                dbHelper = new DBHelper(AddeditCalendarActivity.this);
                dbHelper.deleteCalendar(calendar.getId());
                Intent intent = new Intent();
                intent.putExtra("flag",3   );
                setResult(RESULT_OK,intent);
                finish();
                dialog.dismiss();
            } );
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}