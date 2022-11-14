package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Diary;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryVH> {


    List<Diary> mListDiary;
    Context context;
//    TextView txtitle_diary,txcontent_diary;
   //interface
    Listener listener;


    public DiaryAdapter(List<Diary> mListDiary,Context context,Listener listener) {

        this.mListDiary = mListDiary;
        this.listener=listener;
        this.context=context;
        
    }

    @NonNull
    @Override
    public DiaryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diary,parent,false);
        return new DiaryVH(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryVH holder, int position) {

        Diary diary=mListDiary.get(position);
        if(diary==null)
            return;

        holder.txtitle_diary.setText(diary.getTitle());
//        holder.txcontent_diary.setText(diary.getContentdiary());
        holder.txdatediary.setText(diary.getDatediary());
        holder.linearLayoutDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("Contact");
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
                listener.onClickListenerDiary(diary);



            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                listener.onItemListener(position,phone);
//                listener.onItemListener(diary);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        if(mListDiary!=null)
        {
            return mListDiary.size();
        }
        return 0;
    }

    public class DiaryVH extends RecyclerView.ViewHolder{

        TextView txdatediary,txtitle_diary,txcontent_diary;
        LinearLayout linearLayoutDiary;

        public DiaryVH(@NonNull View itemView) {
            super(itemView);
//            txcontent_diary=itemView.findViewById(R.id.tx_titlediary);
            txtitle_diary=itemView.findViewById(R.id.tx_titlediary);
            txdatediary=itemView.findViewById(R.id.tx_datediary);
            linearLayoutDiary=itemView.findViewById(R.id.linearLayoutDiary);
            

        }
    }
    public interface Listener{
        void onClickListenerDiary(Diary diary);
    }
}
