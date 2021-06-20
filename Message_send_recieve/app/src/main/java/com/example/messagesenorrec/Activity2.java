package com.example.messagesenorrec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Activity2 extends AppCompatActivity {

    TextInputEditText sendermessage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView messagereciever2=findViewById(R.id.messagereciever2);
        sendermessage2=findViewById(R.id.messagesender2);
        Button btn2=findViewById(R.id.btn2);

        Intent i=getIntent();
        String msg=i.getStringExtra("message");
        messagereciever2.setText(msg);

        btn2.setOnClickListener(view->{
            String reply=sendermessage2.getText().toString();
            Intent replyintent=new Intent();
            replyintent.putExtra("reply",reply);
            setResult(RESULT_OK,replyintent);
            finish();
        });
    }
}