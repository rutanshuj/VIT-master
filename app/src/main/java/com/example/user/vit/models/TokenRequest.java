package com.example.user.vit.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenRequest {

    @SerializedName("regno")
    @Expose
    private String regno;

    public TokenRequest() {
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
}
