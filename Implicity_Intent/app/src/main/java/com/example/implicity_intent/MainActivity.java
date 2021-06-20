package com.example.implicity_intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.implicity_intent.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bind = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(bind.getRoot());

        bind.websitebtn.setOnClickListener(view -> {
            String url = bind.textwebsite.getText().toString();
            Uri webPage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "No activity for this task", Toast.LENGTH_SHORT).show();
            }

        });


    }


}