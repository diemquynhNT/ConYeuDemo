package com.example.conyeu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conyeu.R;
import com.example.conyeu.object.Calendar;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalenderVH>{
    ArrayList<Calendar> mListcalendar;
    Listener listener;
    Context context;

    public CalendarAdapter(ArrayList<Calendar> mListcalendar, Context context,Listener listener) {
        this.mListcalendar = mListcalendar;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public CalenderVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_calendar, parent, false);
        return new CalenderVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CalenderVH holder, int position) {
        Calendar calendar = mListcalendar.get(position);
        if (calendar == null){
            return;
        }
        holder.txcalendartitle.setText(calendar.getTitle());
        holder.txCalendarday.setText(calendar.getDate());
        holder.txCalendartime.setText(calendar.getTime());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClickItemCalendar(calendar);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListcalendar != null){
            return mListcalendar.size();
        }
        return 0;
    }




    class CalenderVH extends RecyclerView.ViewHolder {
        public View linearLayoutCalendar;
        TextView txcalendartitle, txCalendarday,txCalendartime;

        public CalenderVH(@NonNull View itemView) {
            super(itemView);
            txcalendartitle = itemView.findViewById(R.id.tx_calendartitle);
            txCalendarday = itemView.findViewById(R.id.tx_calendardate);
            txCalendartime = itemView.findViewById(R.id.tx_calendartime);
            linearLayoutCalendar = itemView.findViewById(R.id.linearLayoutCalendar);
        }
    }

    public interface Listener{
        void onClickItemCalendar(Calendar calendar);
    }
}
