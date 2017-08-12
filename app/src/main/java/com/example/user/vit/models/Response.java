package com.example.user.vit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response<T>{

    @SerializedName("code")
    @Expose
    private T code;

    @SerializedName("type")
    @Expose
    private T type;

    @SerializedName("slot")
    @Expose
    private T slot;

    @SerializedName("class")
    @Expose
    private T class1;

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

    public T getSlot() {
        return slot;
    }

    public void setSlot(T slot) {
        this.slot = slot;
    }

    public T getClass1() {
        return class1;
    }

    public void setClass1(T class1) {
        this.class1 = class1;
    }
}
