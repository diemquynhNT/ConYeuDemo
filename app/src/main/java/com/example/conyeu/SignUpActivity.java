package com.example.conyeu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
    EditText edtUser,edtPass,edtPasscheck;
    Button btnSignup;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtUser=findViewById(R.id.edMail);
        edtPass=findViewById(R.id.edpass);
        edtPasscheck=findViewById(R.id.edpass);
        progressDialog=new ProgressDialog(this);

        btnSignup=findViewById(R.id.btnLogin);
       onClickSignUp();

    }

    private void onClickSignUp() {
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = edtUser.getText().toString().trim();
                String strPass = edtPass.getText().toString().trim();

                    FirebaseAuth auth = FirebaseAuth.getInstance();
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(strUser, strPass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Nhập sai ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });



                }

        });
    }
}