package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Week<T> {

    @SerializedName("MON")
    @Expose
    private Day mon;

    @SerializedName("TUE")
    @Expose
    private Day tue;

    @SerializedName("WED")
    @Expose
    private Day wed;

    @SerializedName("THU")
    @Expose
    private Day thu;

    @SerializedName("FRI")
    @Expose
    private Day fri;


}
