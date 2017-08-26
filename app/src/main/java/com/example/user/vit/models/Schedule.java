package com.example.user.vit.models;

import com.google.gson.annotations.SerializedName;

public class Schedule<T>{

    public Schedule() {
    }

    @SerializedName("code")
    public T code;

    @SerializedName("type")
    public T type;

    @SerializedName("slot")
    public String slot;

    @SerializedName("class")
    public String class1;

    public String course_title;

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getClass1() {
        return class1;
    }
    public void setClass1(String class1) {
        this.class1 = class1;
    }
}
