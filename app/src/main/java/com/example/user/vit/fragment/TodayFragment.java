package com.example.user.vit.fragment;


import android.icu.text.DateFormatSymbols;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Scene;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.vit.R;
import com.example.user.vit.adapters.TodayAdapter;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.Course;
import com.example.user.vit.models.CourseResponse;
import com.example.user.vit.models.Day;
import com.example.user.vit.models.TimeTableResponse;
import com.example.user.vit.models.Schedule;
import com.example.user.vit.models.TokenRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TodayFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private VUApi service;
    List<Course> courses = new ArrayList<>();
    private TextView td;
    List<Schedule> schedule = new ArrayList<>();
    List<String> title_list = new ArrayList<>();
    List<String> faculty_list = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.today_frag, container, false);

        td = (TextView) v.findViewById(R.id.today_date);
        Calendar cal2 = Calendar.getInstance();
        java.text.SimpleDateFormat dayformat  = new java.text.SimpleDateFormat("EEEE", Locale.US);
        final int day1 = cal2.get(Calendar.DAY_OF_MONTH);
        final int month = cal2.get(Calendar.MONTH);
        final int year = cal2.get(Calendar.YEAR);
        final String month2 = new DateFormatSymbols().getMonths()[month-1];
        final String dayofweek = dayformat.format(cal2.getTime());
        final int day = cal2.get(Calendar.DAY_OF_WEEK);
        td.setText(dayofweek + ","+ " " + month2 + " " + day1  +  ","  + " "  + year);
        String link = "http://projectvu.adgvit.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(VUApi.class);

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRegno("15BCE2016");

        Call<TimeTableResponse> responseCall = service.getCourses(tokenRequest);
        Call<CourseResponse> responseCall1  = service.getCourseNames(tokenRequest);

        recyclerView = (RecyclerView) v.findViewById(R.id.today_sub_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        responseCall1.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, retrofit2.Response<CourseResponse> response) {
                CourseResponse cr = response.body();
                Object cr1 = cr.getInfo();
                Gson gson = new Gson();
                String courseList = gson.toJson(cr1);
                try {
                    JSONObject object = new JSONObject(courseList);

                    for(int i = 1; i <=15; i++ ){
                        Object ob = object.get(String.valueOf(i));
                        if (ob instanceof String){

                        }else{
                            Course course = new Course();
                            course.setCourse_code(object.getJSONObject(String.valueOf(i)).getString("Course Code"));
                            course.setCourse_title(object.getJSONObject(String.valueOf(i)).getString("Course Title"));
                            course.setCourse_slot(object.getJSONObject(String.valueOf(i)).getString("Slot"));
                            course.setCourse_fac(object.getJSONObject(String.valueOf(i)).getString("Faculty Name"));
                            courses.add(course);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });

        responseCall.enqueue(new Callback<TimeTableResponse>() {
            @Override
            public void onResponse(Call<TimeTableResponse> call, retrofit2.Response<TimeTableResponse> response) {
                if(response.code() == 200 ){

                    TimeTableResponse response1 = response.body();
                    Gson  gson = new Gson();
                    try {
                        switch(day){
                            case Calendar.SUNDAY:
                                Object o = response1.getWeek().getFri();
                                convertoJSON(o, gson);
                                break;
                            case Calendar.MONDAY:
                                Object i = response1.getWeek().getMon();
                                convertoJSON(i, gson);
                                break;
                            case Calendar.TUESDAY:
                                Object j = response1.getWeek().getTue();
                                convertoJSON(j, gson);
                                break;
                            case Calendar.WEDNESDAY:
                                Object k = response1.getWeek().getWed();
                                convertoJSON(k, gson);
                                break;
                            case Calendar.THURSDAY:
                                Object l = response1.getWeek().getThu();
                                convertoJSON(l, gson);
                                break;
                            case Calendar.FRIDAY:
                                Object m = response1.getWeek().getFri();
                                convertoJSON(m, gson);
                                break;
                            case Calendar.SATURDAY:
                                Object n = response1.getWeek().getSat();
                                convertoJSON(n, gson);
                                break;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<TimeTableResponse> call, Throwable t) {

            }
        });
        return v;
    }
    private JSONObject convertoJSON(Object o, Gson gson) throws JSONException {
        String course = gson.toJson(o);
        JSONObject jsonObject = new JSONObject(course);

        List<Day> days = new ArrayList<>();

        for(int i = 1; i <= 15; i++){
            Object o1 = jsonObject.get(String.valueOf(i));
            if(o1 instanceof String){

            }else{
                Day day = new Day();
                if(i==1){day.setEight_am(jsonObject.get("1"));}
                if(i==2){day.setNine_am(jsonObject.get("2"));}
                if(i==3){day.setTen_am(jsonObject.get("3"));}
                if(i==4){day.setEleven_am(jsonObject.get("4"));}
                if(i==5){day.setTwelve_pm(jsonObject.get("5"));}
                if(i==6){day.setTwelve_forty_pm(jsonObject.get("6"));}
                if(i==7){day.setOne_pm(jsonObject.get("7"));}
                if(i==8){day.setTwo_pm(jsonObject.get("8"));}
                if(i==9){day.setThree_pm(jsonObject.get("9"));}
                if(i==10){day.setFour_pm(jsonObject.get("10"));}
                if(i==11){day.setFive_pm(jsonObject.get("11"));}
                if(i==12){day.setSix_pm(jsonObject.get("12"));}
                if(i==13){day.setSeven_pm(jsonObject.get("13"));}
                if(i==14){day.setEight_pm(jsonObject.get("14"));}
                if(i==15){day.setNine_pm(jsonObject.get("15"));}
                days.add(day);
                String s = jsonObject.get(String.valueOf(i)).toString();
                JSONObject jsonObject1 = new JSONObject(s);
                Schedule schedule1 = new Schedule();

                schedule1.setSlot(jsonObject1.getString("slot"));
                schedule1.setCode(jsonObject1.getString("code"));
                schedule1.setClass1(jsonObject1.getString("class"));
                schedule1.setType(jsonObject1.getString("type"));
                schedule.add(schedule1);



            }
        }

        for(int i =0; i<schedule.size(); i++){
            String scode = String.valueOf(schedule.get(i).getCode());
            innerLoop: for(int j =1; j<=courses.size(); j++){
                String course_code = String.valueOf(courses.get(j).getCourse_code());
                if(course_code.equalsIgnoreCase(scode)){
                    String title = String.valueOf(courses.get(j).getCourse_title());
                    String faculty = String.valueOf(courses.get(j).getCourse_fac());
                    title_list.add(title);
                    faculty_list.add(faculty);
                    break innerLoop;
                }
            }
        }

        TodayAdapter todayAdapter = new TodayAdapter(schedule, days, courses, title_list, faculty_list);
        recyclerView.setAdapter(todayAdapter);
        todayAdapter.notifyDataSetChanged();
        return jsonObject;
    }
}