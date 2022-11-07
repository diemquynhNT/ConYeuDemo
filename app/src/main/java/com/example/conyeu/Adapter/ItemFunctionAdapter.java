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
import com.example.conyeu.camnang_Activity;
import com.example.conyeu.object.ItemFunction;

import java.util.ArrayList;

public class ItemFunctionAdapter extends RecyclerView.Adapter<ItemFunctionAdapter.ItemFunctionVH> {

    ArrayList<ItemFunction> listitem;
    private Context context;

    public ItemFunctionAdapter(ArrayList<ItemFunction> listitem, Context context) {
        this.listitem = listitem;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemFunctionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.itemtitle_row),parent,false);
        return new ItemFunctionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemFunctionVH holder, int position) {
        ItemFunction item=listitem.get(position);
        if(item==null)
        {
            return;
        }
        holder.imgitem.setImageResource(item.getImg());
        holder.txtitleitem.setText(item.getTitleitem());

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
        if(listitem!=null)
        {
            return listitem.size();
        }
        return 0;
    }

    class ItemFunctionVH extends RecyclerView.ViewHolder{
        TextView txtitleitem;
        ImageView imgitem;
        public ConstraintLayout layoutItem;

        public ItemFunctionVH(@NonNull View itemView) {
            super(itemView);
            txtitleitem=itemView.findViewById(R.id.txtitleitem);
            imgitem=itemView.findViewById(R.id.imgitem);
            layoutItem=itemView.findViewById(R.id.layout_itemnew);
        }
    }
}
