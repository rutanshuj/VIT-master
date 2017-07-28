package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Courses {

    @SerializedName("course_time")
    @Expose
    private String course_time;

    @SerializedName("course_name")
    @Expose
    private String course_name;

    @SerializedName("course_code")
    @Expose
    private String course_code;

    @SerializedName("course_slot")
    @Expose
    private String course_slot;

    @SerializedName("course_location")
    @Expose
    private String course_location;

    public Courses() {
    }

    public Courses(String course_time, String course_name, String course_code, String course_slot, String course_location) {
        this.course_time = course_time;
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_slot = course_slot;
        this.course_location = course_location;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
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
