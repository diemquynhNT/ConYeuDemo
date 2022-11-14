package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Baby;
import com.example.conyeu.object.Diary;

import java.util.ArrayList;
import java.util.List;

public class BabyAdapter extends RecyclerView.Adapter<BabyAdapter.BabyVH> {



    ArrayList<Baby> mListBaby;
    Context context;
    Listener listener;

    public BabyAdapter(ArrayList<Baby> mListBaby, Context context, Listener listener) {
        this.mListBaby = mListBaby;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BabyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.listbaby),parent,false);
        return new BabyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BabyVH holder, int position) {

        Baby baby =mListBaby.get(position);
        if(baby==null)
        {
            return;
        }

        holder.txnamebaby.setText(baby.getNamebaby());
        holder.txnicknamebbay.setText(baby.getNickname());
//        holder.txsexbaby.setText(baby.getSexbaby());
//        holder.txperiodbaby.setText(baby.getPeriodbaby());
//        holder.txbirthdaybaby.setText(baby.getBirthday());

       holder.layoutItembaby.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onItemBabyListener(baby);
           }
       });
    }

    @Override
    public int getItemCount() {
        if(mListBaby!=null)
        {
            return mListBaby.size();
        }
        return 0;

    }



    class BabyVH extends RecyclerView.ViewHolder{

        public TextView txnamebaby,txnicknamebbay,txsexbaby,txperiodbaby,txbirthdaybaby;
//        public ImageView Img_Camnang;
        public LinearLayout layoutItembaby;

        public BabyVH(@NonNull View itemView) {
            super(itemView);
            txnamebaby=itemView.findViewById(R.id.tx_namebaby);
            txnicknamebbay=itemView.findViewById(R.id.tx_nicknamebaby);
//            txsexbaby=itemView.findViewById(R.id.tx_sexbaby);
//            txperiodbaby=itemView.findViewById(R.id.tx_periodbaby);
//            txbirthdaybaby=itemView.findViewById(R.id.tx_birthday);
//            Img_Camnang=itemView.findViewById(R.id.imgCamnang);
            layoutItembaby=itemView.findViewById(R.id.layoutlistbaby);
        }
    }

//    public void addBaby(Baby baby){
//        babysFilter.add(baby);
//        notifyDataSetChanged();
//    }
//    public void editBaby(Baby baby, int pos){
//        babysFilter.set(pos, baby);
//        notifyDataSetChanged();
//    }
//
//    public void deleteContact(int pos){
//        babysFilter.remove(pos);
//        notifyDataSetChanged();
//    }
//
//    public void deleteContact(Baby babys){
//        babysFilter.remove(babys);
//        notifyDataSetChanged();
//    }
            public interface Listener{
        void onItemBabyListener(Baby baby);
    }

}
