package com.example.user.vit.fragment;


import android.content.SharedPreferences;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.vit.R;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.Attendance;
import com.example.user.vit.models.AttendanceDetails;
import com.example.user.vit.models.AttendanceResponse;
import com.example.user.vit.models.TimeTableResponse;
import com.example.user.vit.models.TokenRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpFragment extends Fragment{
    private TextView up_code, up_slot, up_loc, up_title;
    List<Attendance> attendances = new ArrayList<>();
    private VUApi service;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.up_frag, container, false);
        up_code = (TextView) v.findViewById(R.id.upcoming_code);
        up_slot = (TextView) v.findViewById(R.id.upcoming_slot);
        up_loc = (TextView) v.findViewById(R.id.upcoming_loc);
        up_title = (TextView) v.findViewById(R.id.upcoming_title);
        String link = "http://projectvu.adgvit.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(VUApi.class);
        Calendar cal = Calendar.getInstance();
        final int day = cal.get(Calendar.DAY_OF_WEEK);
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRegno("15BCE2016");


        Call<TimeTableResponse> timeTableResponseCall = service.getCourses(tokenRequest);
        final Call<AttendanceResponse> attendanceCall = service.getAttendance(tokenRequest);

        attendanceCall.enqueue(new Callback<AttendanceResponse>() {
            @Override
            public void onResponse(Call<AttendanceResponse> call, Response<AttendanceResponse> response) {
                if(response.code() ==200){
                    AttendanceResponse attendanceResponse = response.body();
                    List<AttendanceDetails> o1 = attendanceResponse.getAttendanceDetails();

                    Attendance attendance = new Attendance();
                    Gson gson = new Gson();
                    for(int i = 0; i<o1.size(); i++){
                        String details = gson.toJson(o1.get(i).getAttendance());
                        try {
                            JSONObject jsonObject = new JSONObject(details);
                            attendance.setTitle(jsonObject.getString("CourseTitle"));
                            attendance.setCode(jsonObject.getString("CourseCode"));
                            attendance.setAp(jsonObject.getString("Attendance Percentage"));
                            attendances.add(attendance);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.d("lala", String.valueOf(attendances));
                }
            }

            @Override
            public void onFailure(Call<AttendanceResponse> call, Throwable t) {

            }
        });

        timeTableResponseCall.enqueue(new Callback<TimeTableResponse>() {
            @Override
            public void onResponse(Call<TimeTableResponse> call, Response<TimeTableResponse> response) {
                if(response.code() == 200 ) {
                    TimeTableResponse response1 = response.body();
                    try {
                        Gson gson = new Gson();
                        switch (day) {
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
                    }
                    catch(JSONException e){
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
        String string = gson.toJson(o);
        JSONObject jsonObject = new JSONObject(string);
        int time = 0;

        Calendar cal2 = Calendar.getInstance();
        int hours = cal2.get(Calendar.HOUR_OF_DAY);
            if(hours==8){time= 1;}
            else if(hours == 9){time = 2;}
            else if (hours == 10){time = 3;}
            else if(hours == 11){time = 4;}
            else if(hours == 12){time = 5;}
            else if(hours == 13){time = 7;}
            else if(hours == 14){time = 8;}
            else if(hours == 15){time = 9;}
            else if(hours == 16){time = 10;}
            else if(hours == 17){time = 11;}
            else if(hours == 18){time = 12;}
            else if(hours == 19){time = 13;}
            else if(hours == 20){time = 14;}
            else if(hours == 21){time = 15;}
        int time2 = time+1;
        Object i = jsonObject.get(String.valueOf(time2));


        if(i instanceof String){

        }else{
            String s = jsonObject.get(String.valueOf(time2)).toString();
            JSONObject jsonObject1 = new JSONObject(s);
            up_code.setText(jsonObject1.getString("code"));
            up_slot.setText(jsonObject1.getString("slot"));
            up_loc.setText(jsonObject1.getString("class"));

            String code= jsonObject1.getString("code");
            for(int j=0; j<attendances.size(); j++){
//                Log.d("codeLust", String.valueOf(attendances.get(j)));
//                if(code.equals(attendances.get(j).getCode())){
//                    String course_title = attendances.get(j).getTitle();
//                    up_title.setText(course_title);
//                    break loop;
//                }
            }
        }
        return jsonObject;
    }
}
