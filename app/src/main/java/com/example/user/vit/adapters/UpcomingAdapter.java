package com.example.user.vit.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.vit.R;
import com.example.user.vit.models.Attendance;
import com.example.user.vit.models.Course;
import com.example.user.vit.models.Day;
import com.example.user.vit.models.Schedule;
import com.triggertrap.seekarc.SeekArc;


import java.util.Collections;
import java.util.List;


public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.MyViewHolder> {
    List<Schedule> schedules = Collections.emptyList();
    List<Day> day = Collections.emptyList();
    List<Course> courses = Collections.emptyList();
    List<Attendance> attendances = Collections.emptyList();



    public UpcomingAdapter(List<Schedule> schedule, List<Day> days, List<Course> courses, List<Attendance> attendances) {
            this.schedules = schedule;
            this.day = days;
            this.courses = courses;
            this.attendances = attendances;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upcoming_row, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        for (int i = 0; i < courses.size(); i++) {
            holder.title.setText(courses.get(i + 1).getCourse_title().toString());
            holder.code.setText(courses.get(i+1).getCourse_code().toString());
            holder.location.setText(schedules.get(i+1).getClass1().toString());
            holder.slot.setText(courses.get(i+1).getCourse_slot().toString());
            if(attendances.get(i+1).getCode().equals(courses.get(i+1).getCourse_code())){
                holder.seekArc.setProgress(Integer.parseInt(attendances.get(i+1).getAp().toString()));
            }
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, code, slot, location;
        private SeekArc seekArc;
        private Button addbt, minusbt;
        private TextView per;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.up_subject_name_view);
            code = (TextView) itemView.findViewById(R.id.up_subject_code_view);
            slot = (TextView) itemView.findViewById(R.id.up_subject_slot_view);
            location = (TextView) itemView.findViewById(R.id.up_loc_view);
            seekArc = (SeekArc) itemView.findViewById(R.id.seekArc);
            addbt = (Button) itemView.findViewById(R.id.add);
            minusbt = (Button) itemView.findViewById(R.id.minus);
            per = (TextView) itemView.findViewById(R.id.percent);

            addbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int attc = (int) attendances.get(getAdapterPosition()).getAttc();
                    final int ttc = (int) attendances.get(getAdapterPosition()).getTtc();
                    final int percent = (attc+1/ttc)*100;
                    seekArc.setProgress(percent);
                    per.setText(percent);
                }
            });
            minusbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int attc = (int) attendances.get(getAdapterPosition()).getAttc();
                    final int ttc = (int) attendances.get(getAdapterPosition()).getTtc();
                    if(attc <=0){
                        attc = 0;
                    }
                    final int percent = (attc-1/ttc)*100;
                    seekArc.setProgress(percent);
                    per.setText(percent);
                }
            });
        }
    }
}
