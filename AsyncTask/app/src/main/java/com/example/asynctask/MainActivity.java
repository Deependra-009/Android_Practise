package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn,res;
    private AsyncTask<Void, Integer, Void> task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        ProgressBar pb=findViewById(R.id.pb);



        btn.setOnClickListener(v->{
            Toast.makeText(this,"well done",Toast.LENGTH_SHORT).show();
            task.cancel(true);
        });
        res=findViewById(R.id.restart);
        res.setOnClickListener(v->{
            task = new TimeTask(pb,this).execute();

        });

    }


}

