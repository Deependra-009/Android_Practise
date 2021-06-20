package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=(TextView) findViewById(R.id.show_count);

    }

    public void showToast(View v){
        Toast.makeText(this, "hello friend", Toast.LENGTH_SHORT).show();
    }

    public void countUp(View v)
    {
        mCount++;
        if(mShowCount!=null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
    public void countdecrease(View v)
    {
        mCount=mCount-1;
        if(mShowCount!=null)
        {
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}