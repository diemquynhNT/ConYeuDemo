package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.BMI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BmiList_Activity extends AppCompatActivity {

    Button btnBMI_Detail;
    EditText edheight,edweight,ednamebaby,edage;
    TextView txbmi;
    DBHelper dbHelper;
    BMI bmiedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tính BMI");

        ednamebaby=findViewById(R.id.edt_addnamebb);
        edheight=findViewById(R.id.edtheightbaby);
        edweight=findViewById(R.id.edtweight);
        edage=findViewById(R.id.edtage);
        txbmi=findViewById(R.id.tx_bmi);



        btnBMI_Detail=findViewById(R.id.btnBMI);
        btnBMI_Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DateFormat df = new SimpleDateFormat("d/M/yyyy");
                String date = df.format(Calendar.getInstance().getTime());
                //TINH BMI
                double  heigh=1;
                double  weight=1;
                heigh=Double.valueOf(edheight.getText().toString());
                double heighm=heigh/100;
                weight=Double.valueOf(edweight.getText().toString());

                double result=(double) Math.round((weight/(heighm*heighm))* 10) / 10;
//                result=heigh;
                String test=String.valueOf(result);
                txbmi.setText(test);

                BMI bmi = new BMI(new Random().nextInt(9999),
                            ednamebaby.getText().toString().trim(),
                            date,
                            edheight.getText().toString().trim(),
                            edweight.getText().toString().trim(),
                            txbmi.getText().toString().trim(),
                            edage.getText().toString().trim()
                    );
                    dbHelper=new DBHelper(BmiList_Activity.this);
                    dbHelper.insertBMI(bmi);

            }
        });

    }
        // lay menu option
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.mn_detail,menu);
            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.mnDetail)
        {
            Intent intent=new Intent(BmiList_Activity.this,BMI_DetailActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}