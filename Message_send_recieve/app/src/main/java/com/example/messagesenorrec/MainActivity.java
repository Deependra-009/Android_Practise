package com.example.messagesenorrec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView messagereciever1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messagereciever1=findViewById(R.id.messagereciever1);
        TextInputEditText messagesender1=findViewById(R.id.messagesender1);
        Button btn=findViewById(R.id.btn1);
        btn.setOnClickListener(view->{
            String msg=messagesender1.getText().toString();
            if(msg.length()>0)
            {
                Intent i=new Intent(this,Activity2.class);
                i.putExtra("message",msg);
                startActivityForResult(i,10);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10 && resultCode==RESULT_OK)
        {
            String reply=data.getStringExtra("reply");
            messagereciever1.setText(reply);
        }
    }
}