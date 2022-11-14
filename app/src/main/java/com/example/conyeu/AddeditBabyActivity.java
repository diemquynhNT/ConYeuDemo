package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Diary;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class AddeditBabyActivity extends AppCompatActivity {

    TextInputEditText edtnamebaby,edtnicknamebaby,edtbirthdaybaby;
    TextView txperiod;
    Spinner spsexbaby,spperiodbaby;
    Button btnadd;
    int mYear, mMonth, mDay;
    int flag;
    DBHelper dbHelper;
    Baby baby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addedit_baby);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Thêm con");

        edtnamebaby=findViewById(R.id.edt_namebaby);
        edtnicknamebaby=findViewById(R.id.edt_nickname);

        edtbirthdaybaby=findViewById(R.id.ed_Birthdaybaby);
        edtbirthdaybaby.setOnClickListener(view -> {
            if (view == edtbirthdaybaby) {
                final Calendar calendar = Calendar.getInstance();
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);

                //show dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddeditBabyActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        edtbirthdaybaby.setText(dayOfMonth + "/" + String.format("%02d", month + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        spsexbaby=findViewById(R.id.sp_sexbaby);
        spperiodbaby=findViewById(R.id.sp_periodbaby);
        txperiod=findViewById(R.id.txperiodbb);

        if(spperiodbaby.getSelectedItem().toString()=="Bé đã sinh")
        {
            Toast.makeText(this, "Nhập nội dung trước khi lưu", Toast.LENGTH_SHORT).show();
            txperiod.setText("Sinh nhật");
        }

        // xu ly ten khi flag truyen den
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag", 0);
        if(flag == 1){
            getSupportActionBar().setTitle("Thêm con");

        }else {
            getSupportActionBar().setTitle("Thông tin của con");
            baby = (Baby) intent.getSerializableExtra("BabyEdit");
//            hien thi thong tin da nhap
            edtnamebaby.setText(baby.getNamebaby());
            edtnicknamebaby.setText(baby.getNickname());
            edtbirthdaybaby.setText(baby.getBirthday());
            spperiodbaby.getSelectedItem().toString();
            spsexbaby.getSelectedItem().toString();
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
            if(edtnamebaby.getText().toString().isEmpty()||
                    edtnicknamebaby.getText().toString().isEmpty()||
            edtbirthdaybaby.getText().toString().isEmpty())
            {
                Toast.makeText(this, "Nhập nội dung trước khi lưu", Toast.LENGTH_SHORT).show();
                return false;
            }
            else if(flag==1)
            {

                Baby baby= new Baby(new Random().nextInt(9999),
                        edtnamebaby.getText().toString().trim(),
                        edtnicknamebaby.getText().toString().trim(),
                         spsexbaby.getSelectedItem().toString(),
                        spperiodbaby.getSelectedItem().toString(),
                        edtbirthdaybaby.getText().toString().trim());

                dbHelper=new DBHelper(AddeditBabyActivity.this);
                dbHelper.insertBaby(baby);
                Intent intent = new Intent();
                intent.putExtra("flag",1);
                setResult(RESULT_OK,intent);
                finish();
            }
            else
            {
                Baby babys= new Baby(baby.getId(),
                        edtnamebaby.getText().toString().trim(),
                        edtnicknamebaby.getText().toString().trim(),
                        spsexbaby.getSelectedItem().toString(),
                        spperiodbaby.getSelectedItem().toString(),
                        edtbirthdaybaby.getText().toString().trim());

                dbHelper=new DBHelper(AddeditBabyActivity.this);
                dbHelper.updateBaby(babys);
                Intent intent = new Intent();
                intent.putExtra("flag",2);
                setResult(RESULT_OK,intent);
                finish();
            }
        }
        else if(id==R.id.mnDel)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(AddeditBabyActivity.this);
            builder.setTitle("Con");
            builder.setMessage("Bạn có muốn xóa ".concat(edtnamebaby.getText().toString().trim()).concat("?"));
            builder.setNegativeButton("No",(dialog, i) ->{
                dialog.cancel();
            } );
            builder.setPositiveButton("Yes",(dialog, i) ->{
                dbHelper = new DBHelper(AddeditBabyActivity.this);
                dbHelper.deleteBaby(baby.getId());
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

    //    private void pushdatababy() {
//        FirebaseDatabase database=FirebaseDatabase.getInstance();
//        DatabaseReference myRef=database.getReference("list_baby");
//
//        String name=edtnamebaby.getText().toString();
//        String nickname=edtnicknamebaby.getText().toString();
//        String sexbaby = spsexbaby.getSelectedItem().toString();
//        String periodbaby = spperiodbaby.getSelectedItem().toString();
//        String birthday=edtbirthdaybaby.getText().toString();
//
//        Baby baby=new Baby(name,nickname,sexbaby,periodbaby,birthday);
//
//        String pathObject=String.valueOf(baby.getNamebaby());
//
//        myRef.child(pathObject).setValue(baby, new DatabaseReference.CompletionListener() {
//            //thong bao khi nhap thanh cong
//            @Override
//            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
//                Toast.makeText(AddeditBabyActivity.this,"Nhật kí đã được thêm thành công",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}