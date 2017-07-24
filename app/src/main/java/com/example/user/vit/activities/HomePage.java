package com.example.user.vit.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.user.vit.R;

public class HomePage extends AppCompatActivity {
    Toolbar toolbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        com.example.user.vit.fragment.Nav_Draw nav_draw=(com.example.user.vit.fragment.Nav_Draw) getSupportFragmentManager().findFragmentById(R.id.nav_draw);
        nav_draw.setUp(R.id.nav_draw, (DrawerLayout)findViewById(R.id.draw_layout), toolbar);
        frameLayout=(FrameLayout)findViewById(R.id.frame);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frame, new com.example.user.vit.fragment.Profile());
        ft.commit();
    }
}
