package com.example.drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView nvdrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
    }

    public void logoutfunc(View view){
        closerDrawer(drawerLayout);
        fragmentset("logout");
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.placeholder,new logout());
        ft.commit();

    }

    public void ClickSport(View view){
        closerDrawer(drawerLayout);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.placeholder,new SportFragment());
        ft.commit();

    }

    public void ClickMenu(View view){
//        open drawer
        openDrawer(drawerLayout);
    }
    public void login(View view){
        closerDrawer(drawerLayout);
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        fragmentset("login");

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.placeholder,new login());
        ft.commit();

    }


    public static void openDrawer(DrawerLayout drawerLayout) {
//        open drawer layout

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view){
//        close drawer
        closerDrawer(drawerLayout);
    }

    public static  void closerDrawer(DrawerLayout drawerLayout) {
//        close drawer
//        check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            when drawer is open
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
//        recreate activity
        recreate();
    }
    public void ClickDashboard(View view){
//       redirect activity
        redirectActivity(this,Dashboard.class);
    }
    public void ClickAbout(View view){
        redirectActivity(this,about.class);
    }



    public void ClickLogout(View view){
        logout(this);
    }

    public static void logout(Activity mainActivity) {
        System.exit(0);
    }


    public  static void redirectActivity(Activity activity,Class aclass) {
//        initialize intent
        Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closerDrawer(drawerLayout);
    }
    public void fragmentset(String str){
//        PagerAdapter adapter= new PageAdapter(getSupportFragmentManager(),str);
//        ViewPager pager=findViewById(R.id.pager);
//        pager.setAdapter(adapter);
    }
}




class PageAdapter extends FragmentStatePagerAdapter{
    String string;

    PageAdapter(FragmentManager fm,String str){
        super(fm);
        string=str;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(string.equals("login")){
            return new login();
        }
        if(string.equals("logout")){
            return new logout();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}