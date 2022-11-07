package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.conyeu.fragment_nav.Home_Fragment;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DiaryMainActivity extends AppCompatActivity  {

    private RecyclerView rcvdiary;
    private DiaryAdapter mDiaryAdapter;
    private ArrayList<Diary> mListDiary;
    Button btnupdatediary,btncanceldiary;
    FloatingActionButton btnAdddiary;
    EditText ednewcontent;
    ImageButton btnbacktohome;
    TextView txtitlediary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        // do recyclerview
        rcvdiary=findViewById(R.id.rcv_diary);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvdiary.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvdiary.addItemDecoration(dividerItemDecoration);

        //do du lieu vao
        mListDiary=new ArrayList<>();
        mDiaryAdapter =new DiaryAdapter(mListDiary, this, new DiaryAdapter.Listener() {
            @Override
            public void onClickUpdateiary(Diary diary) {
                //chinh sua diary
                openDialogUpdate(diary);
            }
        });
        rcvdiary.setAdapter(mDiaryAdapter);

        //lay du lieu tu realtime
        getListDiaryDB();

        // btn them diary
        btnAdddiary=findViewById(R.id.btn_fladdDiary);
        btnAdddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiaryMainActivity.this,DiaryActivity.class);
                startActivity(intent);
            }
        });

        btnbacktohome=findViewById(R.id.btntohomediary);
        btnbacktohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiaryMainActivity.this, Home_Fragment.class);
                startActivity(intent);
            }
        });




    }

    //lay du lieu tu lít tren realtime
    private void getListDiaryDB(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference("list_diary");

        //cach nhay vao tung con
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //them moi 1 item
                Diary diary=snapshot.getValue(Diary.class);
                if(diary!=null)
                {
                    mListDiary.add(diary);
                }
                mDiaryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //chinh sua 1 item
                Diary diary=snapshot.getValue(Diary.class);
                if(diary==null||mListDiary!=null ||mListDiary.isEmpty())
                {
                    return;
                }
                for(int i=0;i<mListDiary.size();i++)
                {
                    if(diary.getTitle()==mListDiary.get(i).getTitle())
                    {
                        mListDiary.set(i,diary);
                    }
                }
                mDiaryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                //xoa 1 item
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //di chuyen 1 item
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // khi item loi
            }
        });

    }

    //nhan vao mo xem content chi tiet va sua
    private void openDialogUpdate(Diary diary)
    {
        //khai bao diaglog
        final Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_edit);
        //cua so cua dialog
        Window window=dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        //set cac du lieu cu len
        txtitlediary=dialog.findViewById(R.id.txTitleDiary);
        ednewcontent=dialog.findViewById(R.id.edt_updatecontentdiary);

        btncanceldiary=dialog.findViewById(R.id.btnCancel);
        btnupdatediary=dialog.findViewById(R.id.btnUpdateDiary);

        txtitlediary.setText(diary.getTitle());
        ednewcontent.setText(diary.getContentdiary());


        btncanceldiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        //btn update
        btnupdatediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef=database.getReference("list_diary");
                // tro toi cho sua
                String newcontent=ednewcontent.getText().toString();
                diary.setContentdiary(newcontent);
                myRef.child(String.valueOf(diary.getTitle())).updateChildren(diary.toMap(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(DiaryMainActivity.this,"Cập nhật thành công",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    }
                });

            }
        });



        dialog.show();
    }







}