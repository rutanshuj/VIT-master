package com.example.user.vit.models;


public class Courses {

    private String course_time;
    private String course_name;
    private String course_code;
    private String course_slot;
    private String course_location;

    public Courses(String course_time, String course_name, String course_code, String course_slot, String course_location) {
        this.course_time = course_time;
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_slot = course_slot;
        this.course_location = course_location;
    }

    public Courses() {
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
