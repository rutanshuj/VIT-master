package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Week<T> {

    @SerializedName("MON")
    @Expose
    private T mon;

    @SerializedName("TUE")
    @Expose
    private T tue;

    @SerializedName("WED")
    @Expose
    private T wed;

    @SerializedName("THU")
    @Expose
    private T thu;

    @SerializedName("FRI")
    @Expose
    private T fri;


}
