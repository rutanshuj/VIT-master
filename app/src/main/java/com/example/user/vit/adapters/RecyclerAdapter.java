package com.example.user.vit.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.vit.Info;
import com.example.user.vit.R;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    List<Info> data= Collections.emptyList();
    LayoutInflater layoutInflater;
    private Context context;

    public RecyclerAdapter(Context context, List<Info> data) {
        layoutInflater=LayoutInflater.from(context);
        this.data=data;
        this.context=context;
        // Required empty public constructor
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Info current=data.get(position);
        holder.title.setText(current.title);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title= (TextView)itemView.findViewById(R.id.title);

        }
        @Override
        public void onClick(View v) {

        }
    }
}

