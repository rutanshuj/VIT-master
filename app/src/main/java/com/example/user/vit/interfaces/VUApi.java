package com.example.user.vit.interfaces;


import com.example.user.vit.models.AttendanceResponse;
import com.example.user.vit.models.CourseResponse;
import com.example.user.vit.models.Response;
import com.example.user.vit.models.Schedule;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface VUApi {

    @POST("/timetable")
    Call<Response> getCourses(@Body TokenRequest tokenRequest);

    @POST("/courses")
    Call<CourseResponse> getCourseNames(@Body TokenRequest tokenRequest);

    @POST("/attendance")
    Call<AttendanceResponse> getAttendance (@Body TokenRequest tokenRequest);
}