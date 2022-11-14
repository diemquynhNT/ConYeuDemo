package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
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
        public BMIVH(@NonNull View itemView) {
            super(itemView);
            txname=itemView.findViewById(R.id.tx_datebb);
            txheight=itemView.findViewById(R.id.tx_heightbmibb);
            txweight=itemView.findViewById(R.id.tx_weightbmibb);
            txdatebmi=itemView.findViewById(R.id.tx_datebb);
            txbmi=itemView.findViewById(R.id.tx_bmibb);
            txage=itemView.findViewById(R.id.tx_age);


        }
    }
}
