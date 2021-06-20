package com.example.bakeryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private com.example.bakeryapp.databinding.ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = com.example.bakeryapp.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        
        bind.donut.setOnClickListener(view->{
            Toast.makeText(this,"Donut",Toast.LENGTH_SHORT).show();         
        });
        
        bind.froyo.setOnClickListener(view->{
            Toast.makeText(this, "Froyo", Toast.LENGTH_SHORT).show();
        });
        
        bind.icecream.setOnClickListener(view->{
            Toast.makeText(this, "Icecream", Toast.LENGTH_SHORT).show();
        });
    }
}