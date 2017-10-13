package com.example.user.vit.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AttendanceResponse<T> {

    @SerializedName("info")
    private List<AttendanceDetails> attendanceDetails;

    public List<AttendanceDetails> getAttendanceDetails() {
        return attendanceDetails;
    }

    public void setAttendanceDetails(List<AttendanceDetails> attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }
}
