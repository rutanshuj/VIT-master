package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class Attendance<T> {

    @SerializedName("CourseCode")
    private String code;

    @SerializedName("CourseTitle")
    private String title;

    @SerializedName("Attendance Percentage")
    private String ap;

    @SerializedName("Attended Classes")
    private String attc;

    @SerializedName("Total Classes")
    private String ttc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAttc() {
        return attc;
    }

    public void setAttc(String attc) {
        this.attc = attc;
    }

    public String getTtc() {
        return ttc;
    }

    public void setTtc(String ttc) {
        this.ttc = ttc;
    }
}
