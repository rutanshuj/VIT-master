package com.example.user.vit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Day<T> {

    @SerializedName("1")
    private T eight_am;

    @SerializedName("2")
    private T nine_am;

    @SerializedName("3")
    private T ten_am;

    @SerializedName("4")
    @Expose
    private T eleven_am;

    @SerializedName("5")
    @Expose
    private T twelve_pm;

    @SerializedName("6")
    @Expose
    private T twelve_forty_pm;

    @SerializedName("7")
    @Expose
    private T one_pm;

    @SerializedName("8")
    @Expose
    private T two_pm;

    @SerializedName("9")
    @Expose
    private T three_pm;

    @SerializedName("10")
    @Expose
    private T four_pm;

    @SerializedName("11")
    @Expose
    private T five_pm;

    @SerializedName("12")
    @Expose
    private T six_pm;

    @SerializedName("13")
    @Expose
    private T seven_pm;

    @SerializedName("14")
    @Expose
    private T eight_pm;

    @SerializedName("15")
    @Expose
    private T nine_pm;

    public T getEight_am() {
        return eight_am;
    }

    public void setEight_am(T eight_am) {
        this.eight_am = eight_am;
    }

    public T getNine_am() {
        return nine_am;
    }

    public void setNine_am(T nine_am) {
        this.nine_am = nine_am;
    }

    public T getTen_am() {
        return ten_am;
    }

    public void setTen_am(T ten_am) {
        this.ten_am = ten_am;
    }

    public T getEleven_am() {
        return eleven_am;
    }

    public void setEleven_am(T eleven_am) {
        this.eleven_am = eleven_am;
    }

    public T getTwelve_pm() {
        return twelve_pm;
    }

    public void setTwelve_pm(T twelve_pm) {
        this.twelve_pm = twelve_pm;
    }

    public T getTwelve_forty_pm() {
        return twelve_forty_pm;
    }

    public void setTwelve_forty_pm(T twelve_forty_pm) {
        this.twelve_forty_pm = twelve_forty_pm;
    }

    public T getOne_pm() {
        return one_pm;
    }

    public void setOne_pm(T one_pm) {
        this.one_pm = one_pm;
    }

    public T getTwo_pm() {
        return two_pm;
    }

    public void setTwo_pm(T two_pm) {
        this.two_pm = two_pm;
    }

    public T getThree_pm() {
        return three_pm;
    }

    public void setThree_pm(T three_pm) {
        this.three_pm = three_pm;
    }

    public T getFour_pm() {
        return four_pm;
    }

    public void setFour_pm(T four_pm) {
        this.four_pm = four_pm;
    }

    public T getFive_pm() {
        return five_pm;
    }

    public void setFive_pm(T five_pm) {
        this.five_pm = five_pm;
    }

    public T getSix_pm() {
        return six_pm;
    }

    public void setSix_pm(T six_pm) {
        this.six_pm = six_pm;
    }

    public T getSeven_pm() {
        return seven_pm;
    }

    public void setSeven_pm(T seven_pm) {
        this.seven_pm = seven_pm;
    }

    public T getEight_pm() {
        return eight_pm;
    }

    public void setEight_pm(T eight_pm) {
        this.eight_pm = eight_pm;
    }

    public T getNine_pm() {
        return nine_pm;
    }

    public void setNine_pm(T nine_pm) {
        this.nine_pm = nine_pm;
    }
}
