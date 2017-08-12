package com.example.user.vit.interfaces;


import com.example.user.vit.models.Schedule;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface VUApi {

    @POST("/timetable")
    Call<Schedule> getCourses(@Body TokenRequest tokenRequest);
}