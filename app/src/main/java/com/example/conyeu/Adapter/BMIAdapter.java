package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.SQLite.DBHelper;
import com.example.conyeu.object.BMI;

import java.util.ArrayList;

public class BMIAdapter extends RecyclerView.Adapter<BMIAdapter.BMIVH> {
    ArrayList<BMI> ListBMI;
    Context context;

    public BMIAdapter(ArrayList<BMI> listBMI, Context context) {
        ListBMI = listBMI;
        this.context = context;
    }

    @NonNull
    @Override
    public BMIVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bmi, parent, false);
        return new BMIVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BMIVH holder, int position) {
        BMI bmi = ListBMI.get(position);
        if (bmi == null){
            return;
        }
        holder.txname.setText(bmi.getNamebbbmi());
        holder.txheight.setText(bmi.getHeight());
        holder.txweight.setText(bmi.getWeight());
        holder.txdatebmi.setText(bmi.getDatebmi());
        holder.txbmi.setText(bmi.getBmi());
        holder.txage.setText(bmi.getAge());
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Ghi chú ");
                builder.setMessage("Bạn có muốn xóa BMI không ?");
                builder.setNegativeButton("No",(dialog, i) ->{
                    dialog.cancel();
                } );
                builder.setPositiveButton("Yes",(dialog, i) ->{
                    DBHelper dbHelper = new DBHelper(v.getContext());
                    dbHelper.deleteBMI(bmi.getId());
                    dialog.dismiss();
                    deleteBMIList(bmi);
                } );
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (ListBMI != null){
            return ListBMI.size();
        }
        return 0;
    }

    public class BMIVH extends RecyclerView.ViewHolder {

        TextView txname,txheight,txweight,txdatebmi,txbmi,txage;
        ImageButton btndelete;
        public BMIVH(@NonNull View itemView) {
            super(itemView);
            txname=itemView.findViewById(R.id.tx_namebbbmi);
            txheight=itemView.findViewById(R.id.tx_heightbmibb);
            txweight=itemView.findViewById(R.id.tx_weightbmibb);
            txdatebmi=itemView.findViewById(R.id.tx_datebb);
            txbmi=itemView.findViewById(R.id.tx_bmibb);
            txage=itemView.findViewById(R.id.tx_agebmi);
            btndelete=itemView.findViewById(R.id.btnDeletebmi);


        }
    }

    public void deleteBMIList(BMI bmi){
        ListBMI.remove(bmi);
        notifyDataSetChanged();
    }
}
