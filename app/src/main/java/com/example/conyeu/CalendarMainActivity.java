package com.example.conyeu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

import com.example.conyeu.Adapter.CalendarAdapter;

import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Calendar;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CalendarMainActivity extends AppCompatActivity {

     RecyclerView rvCalendar;
    ArrayList<Calendar> mListcalendar;
     CalendarAdapter calendarAdapter;
    FloatingActionButton btnAddCalendar;
    Calendar calendar;

    DBHelper dbHelper;
    //intent 3
    ActivityResultLauncher<Intent> mLauncher =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK) {
                        mListcalendar = new ArrayList<>();
                        RefreshCalendar();
                    }
                }
            }
    );




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lịch tiêm ngừa cho bé");

        rvCalendar = findViewById(R.id.rcv_listcalendar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvCalendar.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvCalendar.addItemDecoration(dividerItemDecoration);
        dbHelper = new DBHelper(CalendarMainActivity.this);
        mListcalendar= new ArrayList<>();
        RefreshCalendar();




        btnAddCalendar = findViewById(R.id.floatingActionButton_addcalendar);
        btnAddCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarMainActivity.this,AddeditCalendarActivity.class);
                intent.putExtra("CalendarEdit", calendar);
                intent.putExtra("flag",1);
                mLauncher.launch(intent);
            }
        });


    }

    private void RefreshCalendar() {
        ArrayList<Calendar> data = dbHelper.getCalendar();
        mListcalendar.addAll(data);
        calendarAdapter=new CalendarAdapter(mListcalendar, this, new CalendarAdapter.Listener() {
            @Override
            public void onClickItemCalendar(Calendar calendars) {

                onClickUpdateCalendar(calendars);
            }
        });
                rvCalendar.setAdapter(calendarAdapter);
    }

    private void onClickUpdateCalendar(Calendar calendar) {

        Intent intent = new Intent(CalendarMainActivity.this,AddeditCalendarActivity.class);
        intent.putExtra("CalendarEdit", calendar);
        intent.putExtra("flag",2);
        mLauncher.launch(intent);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}



