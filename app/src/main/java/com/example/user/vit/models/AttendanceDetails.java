package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

public class AttendanceDetails <T>{

    @SerializedName("details")
    private Attendance attendance;

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
