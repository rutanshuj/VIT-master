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
import com.example.user.vit.models.Response;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.Callback;
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

        Call<Response> timeTableCall  = service.getCourses(tokenRequest);

        timeTableCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response response) {
                if(response.code() == 200){

                    Response timeTable = response.body();
                    Log.d("TodayFragment", "onReponse: " + response);

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
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
