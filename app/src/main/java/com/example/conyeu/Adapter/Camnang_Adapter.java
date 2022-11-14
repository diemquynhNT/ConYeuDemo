package com.example.conyeu.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.object.Diary;

import java.util.ArrayList;

public class Camnang_Adapter extends  RecyclerView.Adapter<Camnang_Adapter.CamnangVH> {

    private ArrayList<Camnang> Listcamnang;
    private Context context;
    Listener listener;

    public Camnang_Adapter(ArrayList<Camnang> listcamnang,Context context,Listener listener) {
        this.Listcamnang = listcamnang;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CamnangVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.item_row),parent,false);

        return new CamnangVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CamnangVH holder, int position) {

        Camnang cn=Listcamnang.get(position);
        if(cn==null)
        {
            return;
        }
        Bitmap bm= BitmapFactory.decodeByteArray(cn.imgcn,0,cn.imgcn.length);
        holder.Img_Camnang.setImageBitmap(bm);
        holder.tx_titlecn.setText(cn.getTitlecn());
        holder.tx_contentcn.setText(cn.getContentcn());
//        holder.txcontent.setText(cn.getContentcn());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClickListenerCamnang(cn);





            }
        });
    }


    @Override
    public int getItemCount() {
        if(Listcamnang!=null)
        {
            return Listcamnang.size();
        }
        return 0;


    }

    class CamnangVH extends RecyclerView.ViewHolder{

        public TextView tx_titlecn,tx_contentcn,tx_detailcn;
        public ImageView Img_Camnang;
        public ConstraintLayout layoutItem;
        public CamnangVH(@NonNull View itemView) {
            super(itemView);
            tx_titlecn=itemView.findViewById(R.id.tx_titlecn);
            tx_contentcn=itemView.findViewById(R.id.tx_contentcn);
            Img_Camnang=itemView.findViewById(R.id.imgCamnang);
            layoutItem=itemView.findViewById(R.id.layout_item);
        }
    }

    public interface Listener{
        void onClickListenerCamnang(Camnang camnang);
    }
}
