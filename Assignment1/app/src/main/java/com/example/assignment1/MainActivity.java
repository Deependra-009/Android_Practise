package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.assignment1.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        List<String> arr= Arrays.asList("#ffd700","#ffa500","#ff7373","#00ffff","#fa8072","#800000","#00ff00","#8a2be2","#ff0000","#00ffff","#ff00bf","#000000");
        Random r=new Random();
        bind.btncolor.setOnClickListener(view->{
            int index=r.nextInt(arr.size());
            String val=arr.get(index);
            bind.textcolor.setTextColor(Color.parseColor(val));
        });


    }
}