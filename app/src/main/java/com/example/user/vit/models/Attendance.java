package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class Attendance<T> {

    @SerializedName("CourseCode")
    private T code;

    @SerializedName("Attendance Percentage")
    private T ap;

    @SerializedName("Attended Classes")
    private T attc;

    @SerializedName("Total Classes")
    private T ttc;

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }

    public T getAp() {
        return ap;
    }

    public void setAp(T ap) {
        this.ap = ap;
    }

    public T getAttc() {
        return attc;
    }

    public void setAttc(T attc) {
        this.attc = attc;
    }

    public T getTtc() {
        return ttc;
    }

    public void setTtc(T ttc) {
        this.ttc = ttc;
    }
}
