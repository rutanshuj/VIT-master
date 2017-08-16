package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class Week<T> {

    @SerializedName("MON")
    private Day mon;

    @SerializedName("TUE")
    private Day tue;

    @SerializedName("WED")
    private Day wed;

    @SerializedName("THU")
    private Day thu;

    @SerializedName("FRI")
    private Day fri;

    @SerializedName("SAT")
    private Day sat;

    @SerializedName("SUN")
    private Day sun;

    public Day getMon() {
        return mon;
    }

    public void setMon(Day mon) {
        this.mon = mon;
    }

    public Day getTue() {
        return tue;
    }

    public void setTue(Day tue) {
        this.tue = tue;
    }

    public Day getWed() {
        return wed;
    }

    public void setWed(Day wed) {
        this.wed = wed;
    }

    public Day getThu() {
        return thu;
    }

    public void setThu(Day thu) {
        this.thu = thu;
    }

    public Day getFri() {
        return fri;
    }

    public void setFri(Day fri) {
        this.fri = fri;
    }

    public Day getSat() {
        return sat;
    }

    public void setSat(Day sat) {
        this.sat = sat;
    }

    public Day getSun() {
        return sun;
    }

    public void setSun(Day sun) {
        this.sun = sun;
    }
}
