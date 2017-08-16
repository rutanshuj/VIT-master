package com.example.user.vit.fragment;


import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vit.R;
import com.example.user.vit.adapters.TodayAdapter;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.Course;
import com.example.user.vit.models.CourseResponse;
import com.example.user.vit.models.Day;
import com.example.user.vit.models.Response;
import com.example.user.vit.models.Schedule;
import com.example.user.vit.models.TokenRequest;
import com.example.user.vit.models.Week;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TodayFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private VUApi service;
    List<Course> courses = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.today_frag, container, false);


        Calendar calendar = Calendar.getInstance();
        final int day = calendar.get(Calendar.DAY_OF_WEEK);

        Calendar cal2 = Calendar.getInstance();

        final int day1 = Calendar.DAY_OF_MONTH;
        final int month = Calendar.MONTH;

        String link = "http://projectvu.adgvit.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(VUApi.class);

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRegno("15BCE2016");

        Call<Response> responseCall = service.getCourses(tokenRequest);
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

        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.code() == 200 ){

                    Response response1 = response.body();
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
            public void onFailure(Call<Response> call, Throwable t) {

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
        TodayAdapter todayAdapter = new TodayAdapter(schedule, days, courses);
        recyclerView.setAdapter(todayAdapter);

        return jsonObject;
    }

}
