package com.example.user.vit.adapters;

import android.support.transition.Scene;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.vit.R;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.Course;
import com.example.user.vit.models.Day;
import com.example.user.vit.models.Schedule;
import com.example.user.vit.models.TokenRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {


    List<Schedule> schedules = Collections.emptyList();
    List<Day> day = Collections.emptyList();
    List<Course> courses = Collections.emptyList();
    List<String> title;
    List<String> fac_list;

    public TodayAdapter(List<Schedule> schedule, List<Day> days, List<Course> courses, List<String> title_list,
                        List<String> faculty_list) {
        this.schedules = schedule;
        this.day = days;
        this.courses = courses;
        this.title = title_list;
        this.fac_list = faculty_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.today_row_list, parent, false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Schedule sc = schedules.get(position);
        Day dy = day.get(position);
        Log.d("sSize", String.valueOf(schedules.size()));
        Log.d("daySize", String.valueOf(day.size()));

            if(dy.getEight_am() != null ){
                holder.time.setText("08:00 - 08:50");
            }
            if(dy.getNine_am() != null){
                holder.time.setText("09:00 - 09:50");
            }
             if(dy.getTen_am() !=null ){
                holder.time.setText("10:00 - 10: 50");
            }
             if(dy.getEleven_am() != null){
                holder.time.setText("11:00 - 11:50");
            }
             if(dy.getTwelve_pm()!= null && dy.getTwelve_forty_pm() == null){
                holder.time.setText("12:00 - 12:50");
            }
             else if(dy.getTwelve_pm() != null && dy.getTwelve_forty_pm()!= null ){
                holder.time.setText("11:50 - 12:40");
            }
             if(dy.getTwelve_forty_pm()!= null){
                holder.time.setText("12:41 - 01:300");
            }
            if(dy.getTwo_pm()!= null){
                holder.time.setText("02:00 - 02:50");
            }
             if(dy.getThree_pm()!= null){
                holder.time.setText("03:00 - 03:50");
            }
             if(dy.getFour_pm()!= null){
                holder.time.setText("04:00 - 04:50");
            }
             if(dy.getFive_pm()!= null){
                holder.time.setText("05:00 - 05:50");
            }
             if(dy.getSix_pm()!= null){
                holder.time.setText("06:00 - 06:50");
            }
             if(dy.getSeven_pm()!= null){
                holder.time.setText("07:00 - 07:50");
            }
             if(dy.getEight_pm()!= null){
                holder.time.setText("08:00 - 08:50");
            }
             if(dy.getNine_pm()!= null){
                holder.time.setText("09:00 - 09:50");
        }
//        holder.course.setText(title.get(position));
        holder.code.setText(schedules.get(position).getCode().toString());
        holder.location.setText(sc.getClass1());
//        holder.faculty.setText(fac_list.get(position));
        holder.type.setText(schedules.get(position).getType().toString());
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView time, course, location, code, faculty, type;
        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.today_time);
            course = (TextView) itemView.findViewById(R.id.today_subject);
            location = (TextView) itemView.findViewById(R.id.today_location);
            code = (TextView) itemView.findViewById(R.id.today_code);
            faculty = (TextView) itemView.findViewById(R.id.today_faculty);
            type = (TextView) itemView.findViewById(R.id.today_course_type);
        }
    }
}
