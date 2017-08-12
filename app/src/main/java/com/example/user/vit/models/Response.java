package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T> {

    @SerializedName("result")
    @Expose
    private T result;

    @SerializedName("info")
    @Expose
    private Week week;

}
