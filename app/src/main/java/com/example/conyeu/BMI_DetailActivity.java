package com.example.conyeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.conyeu.Adapter.BMIAdapter;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.BMI;

import java.util.ArrayList;

public class BMI_DetailActivity extends AppCompatActivity {

    RecyclerView rcvList;
    DBHelper dbHelper;
    BMIAdapter bmiAdapter;
    ArrayList<BMI> mListcalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Chi tiết");

        rcvList=findViewById(R.id.rcvBMIList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvList.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvList.addItemDecoration(dividerItemDecoration);
        dbHelper = new DBHelper(BMI_DetailActivity.this);
        mListcalendar= new ArrayList<>();
        RefreshBMI();




    }

    private void RefreshBMI() {
        ArrayList<BMI> data = dbHelper.getBMI();
        mListcalendar.addAll(data);
        bmiAdapter=new BMIAdapter(mListcalendar, this);
        rcvList.setAdapter(bmiAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}