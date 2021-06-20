package com.example.drawerlayout;


import android.content.Context;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class  sportadapter extends RecyclerView.Adapter<sportadapter.ViewHolder> {


    private Context ctx;
    private List<sport> msportsdata;
    Fragment frag;

    public sportadapter(Context ctx, List<sport> msportdata,Fragment frag){
        this.ctx=ctx;
        this.msportsdata=msportdata;
        this.frag=frag;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.listitem,parent,false);
        return new ViewHolder(v,this);
    }

    @Override
    public void onBindViewHolder(@NonNull sportadapter.ViewHolder holder, int position) {
        sport currsport=msportsdata.get(position);
        holder.bindto(currsport);
    }

    @Override
    public int getItemCount() {
        return msportsdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private sportadapter adapter1;
        TextView textTitle;
        TextView textSummary;
        ImageView imgSport;

        public ViewHolder(@NonNull  View itemView,sportadapter adapter) {
            super(itemView);
            this.adapter1=adapter;
            textTitle=itemView.findViewById(R.id.heading);
            textSummary=itemView.findViewById(R.id.summary);
            imgSport = itemView.findViewById(R.id.sportimg);

        }

        public void bindto(sport currsport) {
            textTitle.setText(currsport.title);
            textSummary.setText(currsport.summary);
            Glide.with(ctx).load(currsport.image).into(imgSport);
        }
    }
}
