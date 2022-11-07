package com.example.conyeu;

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

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.conyeu.Adapter.BabyAdapter;
import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.object.Diary;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DiaryMainActivity extends AppCompatActivity  {

    private RecyclerView rcvdiary;
    private DiaryAdapter mDiaryAdapter;
    private ArrayList<Diary> mListDiary;
    Button btnupdatediary,btncanceldiary;
    FloatingActionButton btnAdddiary;
    EditText edtnewtitle,ednewcontent,edtnewdate;

//    ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == RESULT_OK) {
//                        if (result.getData().getIntExtra("flag", 0) == 1) {
//                            Phone phones = (Phone) result.getData().getSerializableExtra("contact");
//                            phoneAdapter.addContact(phones);
//                        }
//                    }
//                }
//            }
//    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_main);

        rcvdiary=findViewById(R.id.rcv_diary);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvdiary.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvdiary.addItemDecoration(dividerItemDecoration);

        mListDiary=new ArrayList<>();
        mDiaryAdapter =new DiaryAdapter(mListDiary, this, new DiaryAdapter.Listener() {
            @Override
            public void onClickUpdateiary(Diary diary) {
                //chinh sua diary
                openDialogUpdate(diary);
            }
        });
        rcvdiary.setAdapter(mDiaryAdapter);

        getListDiaryDB();

        btnAdddiary=findViewById(R.id.btn_fladdDiary);
        btnAdddiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiaryMainActivity.this,DiaryActivity.class);
                startActivity(intent);
            }
        });




    }

    private void getListDiaryDB(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef =database.getReference("list_diary");

//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot:snapshot.getChildren())
//                {
//                    Diary diary=dataSnapshot.getValue(Diary.class);
//                    mListDiary.add(diary);
//                }
//                mDiaryAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
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
//        edtnewtitle=dialog.findViewById(R.id.edt_updatetitlediary);
        ednewcontent=dialog.findViewById(R.id.edt_updatecontentdiary);
//        edtnewdate=dialog.findViewById(R.id.edt_updatedatediary);

        btncanceldiary=dialog.findViewById(R.id.btnCancel);
        btnupdatediary=dialog.findViewById(R.id.btnUpdateDiary);

//        edtnewtitle.setText(diary.getTitle());
        ednewcontent.setText(diary.getContentdiary());
//        edtnewdate.setText(diary.getDatediary());

        btncanceldiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnupdatediary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference myRef=database.getReference("list_diary");
                // tro toi cho sua
                String newcontent=ednewcontent.getText().toString();
                diary.setTitle(newcontent);
                myRef.child(String.valueOf(diary.getTitle())).updateChildren(diary.toMap(), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Toast.makeText(DiaryMainActivity.this,"Update sussce",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    }
                });

            }
        });



        dialog.show();
    }







}