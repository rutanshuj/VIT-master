package com.example.user.vit.adapters;

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

    public TodayAdapter(List<Schedule> schedule, List<Day> days, List<Course> course) {
        this.schedules = schedule;
        this.day = days;
        this.courses = course;
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
        if(!dy.getEight_am().toString().equals("nil")){
            holder.time.setText("08:00 - 08:50");
        }
        if(!dy.getNine_am().toString().equals("nil")){
            holder.time.setText("09:00 - 09:50");
        }
        if(!dy.getTen_am().toString().equals("nil")){
            holder.time.setText("10:00 - 10: 50");
        }
        if(!dy.getEleven_am().toString().equals("nil")){
            holder.time.setText("11:00 - 11:50");
        }
        if(!dy.getTwelve_pm().toString().equals("nil") && dy.getTwelve_forty_pm().equals("nil")){
            holder.time.setText("12:00 - 12:50");
        }else{
            holder.time.setText("11:50 - 12:40");
        }
        if(!dy.getTwelve_forty_pm().toString().equals("nil")){
            holder.time.setText("12:41 - 01:300");
        }
        if(!dy.getTwo_pm().toString().equals("nil")){
            holder.time.setText("02:00 - 02:50");
        }
        if(!dy.getThree_pm().toString().equals("nil")){
            holder.time.setText("03:00 - 03:50");
        }
        if(!dy.getFour_pm().toString().equals("nil")){
            holder.time.setText("04:00 - 04:50");
        }
        if(!dy.getFive_pm().toString().equals("nil")){
            holder.time.setText("05:00 - 05:50");
        }
        if(!dy.getSix_pm().toString().equals("nil")){
            holder.time.setText("06:00 - 06:50");
        }
        if(!dy.getSeven_pm().toString().equals("nil")){
            holder.time.setText("07:00 - 07:50");
        }
        if(!dy.getEight_pm().toString().equals("nil")){
            holder.time.setText("08:00 - 08:50");
        }
        if(!dy.getNine_pm().toString().equals("nil")){
            holder.time.setText("09:00 - 09:50");
        }
        holder.location.setText(sc.getClass1());

        for(int i = 1; i<= 15 ; i++){
            if(courses.get(i).getCourse_slot().toString().equals(sc.getSlot())){
                String title = courses.get(i).getCourse_title().toString();
                holder.course.setText(title);
            }
        }
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView time, course, location;
        public MyViewHolder(View itemView) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.today_time);
            course = (TextView) itemView.findViewById(R.id.today_subject);
            location = (TextView) itemView.findViewById(R.id.today_location);
        }
    }
}
