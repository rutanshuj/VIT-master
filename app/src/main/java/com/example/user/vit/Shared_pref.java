package com.example.user.vit;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Shared_pref {
    public static final String PREFS_NAME ="user";
    public static final String PREFS_NAME1 ="password";

    public void saveFavorites(Context context, String favorites) {
        SharedPreferences settings= context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= settings.edit();
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(PREFS_NAME1, jsonFavorites);

        editor.commit();
    }






}
