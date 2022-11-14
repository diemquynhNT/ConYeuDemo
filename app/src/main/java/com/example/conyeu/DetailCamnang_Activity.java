package com.example.conyeu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conyeu.object.Camnang;

public class DetailCamnang_Activity extends AppCompatActivity {

    ImageView imgview_cn;
    TextView txcontent,txdetail,txtitle;
    Camnang camnang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_camnang);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        camnang = (Camnang) getIntent().getSerializableExtra("CamnangView");
        imgview_cn=findViewById(R.id.imgViewcn);
        txcontent=findViewById(R.id.txcontentcn);
        txdetail=findViewById(R.id.txdetailcn);
        getSupportActionBar().setTitle(camnang.getTitlecn());

        Bitmap bm= BitmapFactory.decodeByteArray(camnang.imgcn,0,camnang.imgcn.length);
                imgview_cn.setImageBitmap(bm);

        txcontent.setText(camnang.getContentcn());
        txdetail.setText(camnang.getDetailcn());



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}