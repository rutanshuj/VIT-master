package com.example.user.vit.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vit.R;
import com.example.user.vit.adapters.TodayAdapter;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.TimeTable;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TodayFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private VUApi service;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.today_frag, container, false);

        TodayAdapter todayAdapter = new TodayAdapter();

        String link = "http://projectvu.adgvit.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(link)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(VUApi.class);

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRegno("15BCE2016");

        Call<TimeTable> timeTableCall  = service.getCourses(tokenRequest);

        timeTableCall.enqueue(new Callback<TimeTable>() {
            @Override
            public void onResponse(Call<TimeTable> call, Response<TimeTable> response) {
                int statusCode = response.code();

                TimeTable timeTable = response.body();
                Log.d("TodayFragment", "onResponse: " +timeTable + statusCode);
            }

            @Override
            public void onFailure(Call<TimeTable> call, Throwable t) {
                Log.d("TodayFragment", t.getMessage());

            }
        });
        recyclerView = (RecyclerView) v.findViewById(R.id.today_sub_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(todayAdapter);

        return v;
    }
}
