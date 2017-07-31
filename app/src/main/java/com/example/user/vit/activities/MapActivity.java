package com.example.user.vit.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.user.vit.R;

import static java.security.AccessController.getContext;


public class MapActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_frag);


        ImageView iv = (ImageView) findViewById(R.id.map_img);
        iv.setOnTouchListener(new Touch());
        iv.setScaleType(ImageView.ScaleType.MATRIX);
    }
}
