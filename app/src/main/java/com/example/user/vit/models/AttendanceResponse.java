package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class AttendanceResponse<T> {

    @SerializedName("info")
    private AttendanceDetails attendanceDetails;


    public AttendanceDetails getAttendanceDetails() {
        return attendanceDetails;
    }

    public void setAttendanceDetails(AttendanceDetails attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }
}
