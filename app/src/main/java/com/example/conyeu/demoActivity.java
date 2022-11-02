package com.example.conyeu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class demoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                //user=null=chua login
                if(user==null)
                {
                    Intent intent=new Intent(demoActivity.this,Login_Activity.class);
                    startActivity(intent);

                }else {
                    //login roi
                    Intent intent=new Intent(demoActivity.this,MainActivity.class);
                    startActivity(intent);

                }

            }//gio hiem thi
        },1000);
    }


}