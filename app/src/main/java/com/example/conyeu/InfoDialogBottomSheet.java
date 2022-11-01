package com.example.conyeu;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;

import com.example.conyeu.object.Baby;
import com.example.conyeu.Adapter.BabyAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class InfoDialogBottomSheet extends BottomSheetDialog {
    TextView txFullName, txNickname, txHeight, txWeight,txBirthday;
    ImageView imImage;
    ImageButton btnClose, btnEdit, btnDelete;
    ActivityResultLauncher mLauncher;
    Context context;
    Baby babys;
    BabyAdapter babyAdapter;


    public InfoDialogBottomSheet(@NonNull Context context, ActivityResultLauncher mLauncher, Baby babys, BabyAdapter babyAdapter) {
        super(context);
        this.mLauncher = mLauncher;
        this.babys = babys;
        this.babyAdapter = babyAdapter;
    }

    public void findView(){
        View view = getLayoutInflater().inflate(R.layout.activity_info_baby,null);
        txFullName=view.findViewById(R.id.fullName);
        txNickname=view.findViewById(R.id.fullNickname);
        txHeight=view.findViewById(R.id.txheight);
        txWeight=view.findViewById(R.id.txweight);
        txBirthday=view.findViewById(R.id.txBirthday);

        //cancel
        btnClose=view.findViewById(R.id.cancelBtn);
        btnClose.setOnClickListener( v -> {
            this.dismiss();
        });

        //edit
        btnEdit=view.findViewById(R.id.editBtn);
        btnEdit.setOnClickListener(v->{
            Intent intent = new Intent(getContext(), AddeditBabyActivity.class);
//            intent.putExtra("contact", baby);
            intent.putExtra("flag", 2 );
            mLauncher.launch(intent);
            dismiss();

        });

        btnDelete=view.findViewById(R.id.deleteBtn);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setTitle("Contacts");
                builder.setMessage("Delete ".concat("Xóa"));
                builder.setNegativeButton("No", (dialogInterface, i) -> {
                    dialogInterface.cancel();


                });
                builder.setPositiveButton("Yes", (dialogInterface, i) -> {
//                    babyAdapter.deleteContact(phones);
//                    dialogInterface.dismiss();
//                    dismiss();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

//        txFullName.setText(babys.getNamebaby());
//        txNickname.setText(babys.getNickname());
//        txHeight.setText(babys.getHeightbaby());
//        txWeight.setText(babys.getWeightbaby());
//        txBirthday.setText(babys.getBirthday());



        setContentView(view);



    }
}
