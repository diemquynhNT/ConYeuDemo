package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.conyeu.create.createcalendar_Activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class calendar_Activity extends AppCompatActivity {

    FloatingActionButton btnadd;
    ImageButton btnback;
    Button btnpush,btnget;
    TextInputEditText txpush;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
//
//        btnadd=findViewById(R.id.btnaddcalendar);
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent=new Intent(calendar_Activity.this, createcalendar_Activity.class);
//                intent.putExtra("flag",1);
//                startActivity(intent);
//            }
//        });
////
//        btnback=findViewById(R.id.btnBackhome);
//        btnback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent=new Intent(calendar_Activity.this, MainActivity.class);
//                //intent.putExtra("flag",1);
//                startActivity(intent);
//            }
//        });

    }
}