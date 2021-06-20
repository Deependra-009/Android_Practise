package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("life","onCreat() called");
        Button btn=findViewById(R.id.btnsend1);
        btn.setOnClickListener(view->{
            Intent i=new Intent(this,Second_Activity.class);
            startActivity(i);
        });
        Button btn2=findViewById(R.id.btnsend2);
        btn2.setOnClickListener(view->{
            Intent i1=new Intent(this,ThirdActivity.class);
            startActivity(i1);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("life","onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life","onPause() called");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","onStop() called");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("life","onRstart() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","onDestroy() called");
    }
}