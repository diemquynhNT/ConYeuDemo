package com.example.conyeu.bottomsheetdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;

import com.example.conyeu.AddeditBabyActivity;
import com.example.conyeu.DiaryActivity;
import com.example.conyeu.R;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.Baby;
import com.example.conyeu.Adapter.BabyAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class  InfoDialogBottomSheet extends BottomSheetDialog {
    TextView txFullName, txNickname, txperiod, txsex, txBirthday;
    ImageButton btnClose, btnEdit, btnDelete;
    Context context;
    Baby baby;
    BabyAdapter babyAdapter;
    ActivityResultLauncher mLauncher;


    DBHelper dbHelper;

    public InfoDialogBottomSheet(@NonNull Context context, Baby baby,ActivityResultLauncher mLauncher,BabyAdapter babyAdapter) {
        super(context);
        this.baby = baby;
        this.mLauncher=mLauncher;
        this.babyAdapter = babyAdapter;
    }

    public void findView() {
        View view = getLayoutInflater().inflate(R.layout.activity_info_baby, null);
        txFullName = view.findViewById(R.id.fullName);
        txNickname = view.findViewById(R.id.txnickname);
        txperiod = view.findViewById(R.id.txperiodbaby);
        txsex = view.findViewById(R.id.txsexbaby);
        txBirthday = view.findViewById(R.id.txBirthday);


//        txFullName.setText(baby.getNamebaby());



        //cancel
        btnClose = view.findViewById(R.id.cancelBtn);
        btnClose.setOnClickListener(v -> {
            this.dismiss();
        });

////        edit
        btnEdit = view.findViewById(R.id.editBtn);
        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(view.getContext(), AddeditBabyActivity.class);
            intent.putExtra("BabyEdit", baby);
            intent.putExtra("flag",2);
            mLauncher.launch(intent);
            this.dismiss();
//

        });


        txFullName.setText(baby.getNamebaby());
        txNickname.setText(baby.getNickname());
        txperiod.setText(baby.getPeriodbaby());
        txsex.setText(baby.getSexbaby());
        txBirthday.setText(baby.getBirthday());



        setContentView(view);


    }
}
