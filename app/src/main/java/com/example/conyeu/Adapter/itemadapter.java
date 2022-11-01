package com.example.conyeu.Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.conyeu.camnang_Activity;

import java.util.ArrayList;

public class itemadapter extends RecyclerView.Adapter<itemadapter.CamnangVH> {
    private Context mContext;
    Camnang camnang;
    private ArrayList<Camnang> Listcamnang;
    private Context context;

    public itemadapter(ArrayList<Camnang> listcamnang, Context context) {
        this.Listcamnang = listcamnang;
        this.context = context;
    }

    @NonNull
    @Override
    public CamnangVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.itemtitle_row),parent,false);

        return new CamnangVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CamnangVH holder, int position) {

        Camnang cn=Listcamnang.get(position);
        if(cn==null)
        {
            return;
        }
        holder.imgitem.setImageResource(cn.getImage_cn());
        holder.txTitle.setText(cn.getTitle());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cn.getTitle()=="Thông tin của con")
                {
                    Intent intent=new Intent(context, camnang_Activity.class);
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("object_user",cn);
//                intent.putExtras(bundle);
                    context.startActivity(intent);
                }
                else if (cn.getTitle()=="Cẩm nang") {

                }
                else if (cn.getTitle()=="Thông tin của mẹ") {

                }
                else if (cn.getTitle()=="Lịch tiêm ngừa theo tháng") {
                    Intent intent=new Intent(context, camnang_Activity.class);
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("object_user",cn);
//                intent.putExtras(bundle);
                    context.startActivity(intent);
                }



//


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

        public TextView txTitle;
        public ImageView imgitem;
        public ConstraintLayout layoutItem;
        public CamnangVH(@NonNull View itemView) {
            super(itemView);
            txTitle=itemView.findViewById(R.id.txtitle);
            imgitem=itemView.findViewById(R.id.imgitem);
            layoutItem=itemView.findViewById(R.id.layout_itemnew);
        }
    }
}
