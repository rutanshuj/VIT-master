package com.example.user.vit.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vit.R;
import com.example.user.vit.interfaces.VUApi;
import com.example.user.vit.models.TimeTable;
import com.example.user.vit.models.TokenRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.MyViewHolder> {
    private VUApi service;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.today_row_list, parent, false);

        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://projectvu.adgvit.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = builder.create(VUApi.class);

        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRegno("15BCE2016");



        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
