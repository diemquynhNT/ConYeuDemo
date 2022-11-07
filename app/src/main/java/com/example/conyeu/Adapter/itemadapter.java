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

import com.example.conyeu.DiaryMainActivity;
import com.example.conyeu.R;
import com.example.conyeu.calendar_Activity;
import com.example.conyeu.object.Camnang;
import com.example.conyeu.camnang_Activity;
import com.example.conyeu.object.ItemFunction;

import java.util.ArrayList;

public class itemadapter extends RecyclerView.Adapter<itemadapter.CamnangVH> {

    private ArrayList<ItemFunction> Listitem;
    private Context context;

    public itemadapter(ArrayList<ItemFunction> listitem, Context context) {
        this.Listitem = listitem;
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

        ItemFunction item=Listitem.get(position);
        if(item==null)
        {
            return;
        }

        holder.imgitem.setImageResource(item.getImg());
        holder.txTitleitem.setText(item.getTitleitem());
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(item.getTitleitem()=="Thông báo")
                {

                }
                else if (item.getTitleitem()=="Cẩm nang") {
                    Intent intent=new Intent(context, camnang_Activity.class);
//                Bundle bundle=new Bundle();
//                bundle.putSerializable("object_user",cn);
//                intent.putExtras(bundle);
                    context.startActivity(intent);

                }
                else if (item.getTitleitem()=="Nhật kí") {
                    Intent intent=new Intent(context, DiaryMainActivity.class);
                    context.startActivity(intent);

                }
                else if (item.getTitleitem()=="Lịch tiêm ngừa theo tháng") {
                    Intent intent=new Intent(context, calendar_Activity.class);
                    context.startActivity(intent);
                }



//


            }
        });
    }

    @Override
    public int getItemCount() {
        if(Listitem!=null)
        {
            return Listitem.size();
        }
        return 0;
    }


    class CamnangVH extends RecyclerView.ViewHolder{

        public TextView txTitleitem;
        public ImageView imgitem;
        public ConstraintLayout layoutItem;
        public CamnangVH(@NonNull View itemView) {
            super(itemView);
            txTitleitem=itemView.findViewById(R.id.txtitleitem);
            imgitem=itemView.findViewById(R.id.imgitem);
            layoutItem=itemView.findViewById(R.id.layout_itemnew);
        }
    }
}
