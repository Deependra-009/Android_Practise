package com.example.drawerlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        drawerLayout=findViewById(R.id.drawer_layout);


    }

    public void ClickMenu(View view){

        MainActivity.openDrawer(drawerLayout);

    }

    public void ClickLogo(View view){

        MainActivity.closerDrawer(drawerLayout);

    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this, Dashboard.class);
    }

    public void ClickAbout(View view){

        recreate();

    }

    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closerDrawer(drawerLayout);
    }
}