package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeTable {

    @SerializedName("class")
    @Expose
    private String course_name;

    @SerializedName("code")
    @Expose
    private String course_code;

    @SerializedName("slot")
    @Expose
    private String course_slot;

    @SerializedName("class")
    @Expose
    private String course_location;

    public TimeTable() {
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_slot() {
        return course_slot;
    }

    public void setCourse_slot(String course_slot) {
        this.course_slot = course_slot;
    }

    public String getCourse_location() {
        return course_location;
    }

    public void setCourse_location(String course_location) {
        this.course_location = course_location;
    }
}
