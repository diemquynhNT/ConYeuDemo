package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ContentInfoCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.conyeu.Adapter.DiaryAdapter;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Diary;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class DiaryActivity extends AppCompatActivity {

    ArrayList<Diary> mLis;
   EditText edtcontent,edttitle,eddate;
    DBHelper dbHelper;
    ArrayList<Diary> mListDiary;
    Diary diary;
    DiaryAdapter mDiaryAdapter;
    int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        edttitle=findViewById(R.id.edAddDiary);
        edtcontent=findViewById(R.id.edtAddcontent);

        // xu ly ten khi flag truyen den
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if(flag == 1){
            getSupportActionBar().setTitle("Thêm mới nhật kí");

        }else {
            getSupportActionBar().setTitle("Chỉnh sửa nhật kí");
            diary = (Diary) intent.getSerializableExtra("DiaryEdit");
            //hien thi thong tin da nhap
            edttitle.setText(diary.getTitle());
            edtcontent.setText(diary.getContentdiary());
        }

    }

    // lay menu option
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
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());

        if(id==R.id.mnSave)
        {
            if(edttitle.getText().toString().isEmpty()||edtcontent.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Nhập nội dung trước khi lưu", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if(flag==1)
            {

                Diary diary = new Diary(new Random().nextInt(9999),
                        edttitle.getText().toString().trim(),
                        edtcontent.getText().toString().trim(),
                        date );
                dbHelper=new DBHelper(DiaryActivity.this);
                dbHelper.insertDiary(diary);
                Intent intent = new Intent();
                intent.putExtra("flag",1);
                setResult(RESULT_OK,intent);

                finish();
            }
            else
            {
                Diary diarys = new Diary(diary.getId(),
                        edttitle.getText().toString().trim(),
                        edtcontent.getText().toString().trim(),
                        date );
                dbHelper=new DBHelper(DiaryActivity.this);
                dbHelper.updateDiary(diarys);
                Toast.makeText(this, "Nhập nội dung trước khi lưu", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent();
                intent.putExtra("flag",2);
                setResult(RESULT_OK,intent);

                finish();
            }
        }
        else if(id==R.id.mnDel)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(DiaryActivity.this);
            builder.setTitle("Nhật kí");
            builder.setMessage("Bạn có muốn xóa nhật kí ".concat(edttitle.getText().toString().trim()).concat("?"));
            builder.setNegativeButton("No",(dialog, i) ->{
                dialog.cancel();
            } );
            builder.setPositiveButton("Yes",(dialog, i) ->{
                dbHelper = new DBHelper(DiaryActivity.this);
                dbHelper.deleteDiary(diary.getId());
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