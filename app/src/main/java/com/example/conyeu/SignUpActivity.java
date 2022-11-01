package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText edtUser,edtPass;
    Button btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtUser=findViewById(R.id.username);
        edtPass=findViewById(R.id.password);
        btnSignup=findViewById(R.id.btnLogin);
       onClickSignUp();

    }

    private void onClickSignUp() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser=edtUser.getText().toString().trim();
                String strPass=edtPass.getText().toString().trim();
                FirebaseAuth auth=FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(strUser,strPass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                            finishAffinity();
                        }else {
                            Toast.makeText(SignUpActivity.this,"FAILED",Toast.LENGTH_SHORT).show();
                        }
                    }
                });




            }
        });
    }
}