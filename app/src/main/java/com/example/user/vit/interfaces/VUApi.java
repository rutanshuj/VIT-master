package com.example.user.vit.interfaces;


import com.example.user.vit.models.Courses;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface VUApi {

    @POST("/auth/courses")
    Call<Courses> getCourses(@Body TokenRequest tokenRequest);
}
