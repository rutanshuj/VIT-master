package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class CourseResponse<T> {

    @SerializedName("result")
    private T result;

    @SerializedName("info")
    private CourseList info;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public CourseList getInfo() {
        return info;
    }

    public void setInfo(CourseList info) {
        this.info = info;
    }
}
