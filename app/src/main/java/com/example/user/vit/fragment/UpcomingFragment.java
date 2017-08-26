package com.example.user.vit.fragment;


import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vit.R;
import com.example.user.vit.adapters.UpcomingAdapter;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.Attendance;
import com.example.user.vit.models.AttendanceResponse;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private VUApi service;
    List<Course> courses = new ArrayList<>();
    List<Attendance> attendances = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.upcoming_frag, container, false);
        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_WEEK);
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
        Call<AttendanceResponse> attendanceResponseCall = service.getAttendance(tokenRequest);



        recyclerView = (RecyclerView) v.findViewById(R.id.up_rec_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        attendanceResponseCall.enqueue(new Callback<AttendanceResponse>() {
            @Override
            public void onResponse(Call<AttendanceResponse> call, retrofit2.Response<AttendanceResponse> response) {
                AttendanceResponse attendance = response.body();
                Object a = attendance.getAttendanceDetails().getAttendance();
                Gson gson = new Gson();
                String attlist = gson.toJson(a);

                try {
                    JSONObject jsonObject = new JSONObject(attlist);

                    for(int i = 1; i<=15; i++){
                        Object  ob = jsonObject.get(String.valueOf(i));
                        if(ob instanceof String){

                        }else{
                            Attendance attendance1 = new Attendance();

                            attendance1.setCode(jsonObject.getString("CourseCode"));
                            attendance1.setCode(jsonObject.getString("Attendance Percentage"));
                            attendance1.setAttc(jsonObject.getString("Attended Classes"));
                            attendance1.setTtc(jsonObject.getString("Total Classes"));
                            attendances.add(attendance1);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AttendanceResponse> call, Throwable t) {

            }
        });

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
                                Object o = response1.getWeek().getSun();
                                convertoJSON(o, gson);
                            case Calendar.MONDAY:
                                Object i = response1.getWeek().getMon();
                                convertoJSON(i, gson);

                            case Calendar.TUESDAY:
                                Object j = response1.getWeek().getTue();
                                convertoJSON(j, gson);

                            case Calendar.WEDNESDAY:
                                Object k = response1.getWeek().getWed();
                                convertoJSON(k, gson);

                            case Calendar.THURSDAY:
                                Object l = response1.getWeek().getThu();
                                convertoJSON(l, gson);

                            case Calendar.FRIDAY:
                                Object m = response1.getWeek().getFri();
                                convertoJSON(m, gson);

                            case Calendar.SATURDAY:
                                Object n = response1.getWeek().getSat();
                                convertoJSON(n, gson);
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
        List<Schedule> schedule = new ArrayList<>();
        List<Day> days = new ArrayList<>();

        for(int i = 1; i <= 15; i++){
            Object o1 = jsonObject.get(String.valueOf(i));
            if(o1 instanceof String){

            }else{
                String s = jsonObject.get(String.valueOf(i)).toString();
                JSONObject jsonObject1 = new JSONObject(s);
                Schedule schedule1 = new Schedule();
                Day day = new Day();
                day.setEight_am(jsonObject.get("1"));
                day.setNine_am(jsonObject.get("2"));
                day.setTen_am(jsonObject.get("3"));
                day.setEleven_am(jsonObject.get("4"));
                day.setTwelve_pm(jsonObject.get("5"));
                day.setTwelve_forty_pm(jsonObject.get("6"));
                day.setOne_pm(jsonObject.get("7"));
                day.setTwo_pm(jsonObject.get("8"));
                day.setThree_pm(jsonObject.get("9"));
                day.setFour_pm(jsonObject.get("10"));
                day.setFive_pm(jsonObject.get("11"));
                day.setSix_pm(jsonObject.get("12"));
                day.setSeven_pm(jsonObject.get("13"));
                day.setEight_pm(jsonObject.get("14"));
                day.setNine_pm(jsonObject.get("15"));
                schedule1.setSlot(jsonObject1.getString("slot"));
                schedule1.setCode(jsonObject1.getString("code"));
                schedule1.setClass1(jsonObject1.getString("class"));
                schedule1.setType(jsonObject1.getString("type"));

                schedule.add(schedule1);
                days.add(day);

            }
        }

        Log.d("Json", String.valueOf(schedule.size()));
        UpcomingAdapter upcomingAdapter = new UpcomingAdapter(schedule, days, courses, attendances);
        recyclerView.setAdapter(upcomingAdapter);

        return jsonObject;
    }

}
