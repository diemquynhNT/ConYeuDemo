package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.conyeu.Adapter.Camnang_Adapter;
import com.example.conyeu.object.Camnang;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DiaryActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Camnang> Listcamnang;
    private Camnang_Adapter camnangAdapter;
    DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        mRecyclerView=findViewById(R.id.rvdiary);
        database=FirebaseDatabase.getInstance().getReference("list_user");

//        camnangAdapter = new Camnang_Adapter(getListUser(),this.getContext());
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//        //phan canh
//        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        mRecyclerView.addItemDecoration(dividerItemDecoration);


        Listcamnang=new ArrayList<>();
        camnangAdapter= new Camnang_Adapter(Listcamnang,this);
        mRecyclerView.setAdapter(camnangAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Camnang cn=dataSnapshot.getValue(Camnang.class);
                    Listcamnang.add(cn);
                }

                camnangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void initUi()
    {


    }

    public void getListDB(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list_user");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot datasnapshot: snapshot.getChildren())
                {
                    Camnang cn=datasnapshot.getValue(Camnang.class);
                    Listcamnang.add(cn);
                }
                camnangAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DiaryActivity.this);
                builder.setTitle("Contact");
                builder.setMessage("loi");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}