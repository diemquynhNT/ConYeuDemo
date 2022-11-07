package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Baby;

import java.util.ArrayList;

public class BabyAdapter extends RecyclerView.Adapter<BabyAdapter.BabyVH> implements Filterable {

//    private Context mContext;
//    Camnang camnang;
    Baby baby;
    private ArrayList<Baby> babys;
    private ArrayList<Baby> babysFilter;

    private Context context;
//    Listener listener;

    public BabyAdapter(ArrayList<Baby> babys) {
        this.babys = babys;
//        this.listener=listener;
        this.babysFilter=babys;

    }

    @NonNull
    @Override
    public BabyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.listbaby),parent,false);

        return new BabyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BabyVH holder, int position) {

        Baby cn =babysFilter.get(position);
        if(cn==null)
        {
            return;
        }

        holder.txTitle.setText(cn.getNamebaby());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(context,AddeditBabyActivity.class);
////                Bundle bundle=new Bundle();
////                bundle.putSerializable("object_user",cn);
////                intent.putExtras(bundle);
//                context.startActivity(intent);
//                listener.onItemListener(cn);
//



            }
        });
    }

    @Override
    public int getItemCount() {
        if(babys!=null)
        {
            return babys.size();
        }
        return 0;

    }

    @Override
    public Filter getFilter() {
        return null;
    }

    class BabyVH extends RecyclerView.ViewHolder{

        public TextView txTitle;
        public ImageView Img_Camnang;
        public ConstraintLayout layoutItem;

        public BabyVH(@NonNull View itemView) {
            super(itemView);
            txTitle=itemView.findViewById(R.id.txnamebaby);
//            Img_Camnang=itemView.findViewById(R.id.imgCamnang);
            layoutItem=itemView.findViewById(R.id.layoutlistbaby);
        }
    }

    public void addBaby(Baby baby){
        babysFilter.add(baby);
        notifyDataSetChanged();
    }
    public void editBaby(Baby baby, int pos){
        babysFilter.set(pos, baby);
        notifyDataSetChanged();
    }

    public void deleteContact(int pos){
        babysFilter.remove(pos);
        notifyDataSetChanged();
    }

    public void deleteContact(Baby babys){
        babysFilter.remove(babys);
        notifyDataSetChanged();
    }
    public interface Listener{
        void onItemListener(Baby baby);
    }

}
