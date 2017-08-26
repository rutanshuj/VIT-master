package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class TimeTableResponse<T> {

    @SerializedName("result")
    private T result;

    @SerializedName("info")
    private Week week;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }
}
