package com.example.conyeu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Diary;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryVH> {


    List<Diary> mListDiary;
//    TextView txtitle_diary,txcontent_diary;

    public DiaryAdapter(List<Diary> mListDiary) {
        this.mListDiary = mListDiary;
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
        holder.txcontent_diary.setText(diary.getContentdiary());
        holder.txiddiary.setText(diary.getTitle());


    }

    @Override
    public int getItemCount() {
        if(mListDiary!=null)
        {
            return mListDiary.size();
        }
        return 0;
    }

    protected class DiaryVH extends RecyclerView.ViewHolder{

        private TextView txiddiary,txtitle_diary,txcontent_diary;

        public DiaryVH(@NonNull View itemView) {
            super(itemView);
            txcontent_diary=itemView.findViewById(R.id.tx_contentdiary);
            txtitle_diary=itemView.findViewById(R.id.tx_titlediary);
            txiddiary=itemView.findViewById(R.id.tx_iddiary);

        }
    }
}
