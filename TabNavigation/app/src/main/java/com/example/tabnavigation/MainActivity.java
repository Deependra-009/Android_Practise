package com.example.tabnavigation;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tabnavigation.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private ViewPager pager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PagerAdapter adapter=new PageAdapter(getSupportFragmentManager());
        pager = binding.content.pager;
        pager.setAdapter(adapter);
        tabLayout = binding.content.tabLayout;
        tabLayout.setupWithViewPager(pager);


    }

    class PageAdapter extends FragmentStatePagerAdapter{

        public PageAdapter(@NonNull FragmentManager fm){
            super(fm);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:return new FirstFragment();
                case 1:return new SecondFragment();
                case 2:return new ThirdFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:return "One";
                case 1:return "Two";
                case 2:return "Three";
            }
            return super.getPageTitle(position);
        }
    }

}

