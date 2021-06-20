package com.example.sportsapp;

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

public class  SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {


    private Context ctx;
    private List<sport> msportsdata;
    Fragment frag;

    public SportsAdapter(Context ctx, List<sport> msportdata,Fragment frag){
        this.ctx=ctx;
        this.msportsdata=msportdata;
        this.frag=frag;
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v,this);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull SportsAdapter.ViewHolder holder, int position) {
        sport currsport=msportsdata.get(position);
        holder.bindto(currsport);
    }

    @Override
    public int getItemCount() {
        return msportsdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private SportsAdapter adapter;
        TextView textTitle;
        TextView textSummary;
        ImageView imgSport;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView,SportsAdapter adapter) {
            super(itemView);
            this.adapter=adapter;
            textTitle=itemView.findViewById(R.id.heading);
            textSummary=itemView.findViewById(R.id.summary);
            imgSport = itemView.findViewById(R.id.sportsimg);
            itemView.setOnClickListener(v->{
                int pos=getAdapterPosition();
                sport s=msportsdata.get(pos);
                FirstFragmentDirections.ActionFirstFragmentToSecondFragment dir = FirstFragmentDirections.actionFirstFragmentToSecondFragment(s.image);
                dir.setTitle(s.title.toString());
                dir.setSummary(s.summary.toString());
                NavHostFragment.findNavController(frag).navigate(dir);



            });
        }

        public void bindto(sport currsport) {
            textTitle.setText(currsport.title);
            textSummary.setText(currsport.summary);
            Glide.with(ctx).load(currsport.image).into(imgSport);
        }
    }
}
