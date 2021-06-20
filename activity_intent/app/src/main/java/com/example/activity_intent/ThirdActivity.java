package com.example.activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    int count=0;
    TextView showcount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        showcount=(TextView) findViewById(R.id.textviewcount);
        Button btndec=findViewById(R.id.btndec);
        btndec.setOnClickListener(view->{
            count=count-1;
            showcount.setText(Integer.toString(count));
        });
        Button btninc=findViewById(R.id.btninc);
        btninc.setOnClickListener(view->{
            count=count+1;
            showcount.setText(Integer.toString(count));
        });
    }


}