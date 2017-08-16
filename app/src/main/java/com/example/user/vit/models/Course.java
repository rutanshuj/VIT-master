package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class Course<T> {
    public Course() {
    }

    @SerializedName("Course Code")
    private T course_code;

    @SerializedName("Course Title")
    private T course_title;

    @SerializedName("Slot")
    private T course_slot;

    public T getCourse_code() {
        return course_code;
    }

    public void setCourse_code(T course_code) {
        this.course_code = course_code;
    }

    public T getCourse_title() {
        return course_title;
    }

    public void setCourse_title(T course_title) {
        this.course_title = course_title;
    }

    public T getCourse_slot() {
        return course_slot;
    }

    public void setCourse_slot(T course_slot) {
        this.course_slot = course_slot;
    }
}
