package com.pavi.example.fragmentstest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tb);
        viewpage=findViewById(R.id.myviewpager);
        viewpage.setAdapter(new MyFragamentPagerAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(viewpage);
    }
    public class MyFragamentPagerAdapter extends FragmentPagerAdapter {
        String tabTiles[] = {"Chats", "Status", "Calls"};

        public MyFragamentPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ChatsFragment();
            }

            if(position ==0) {
                return new StatusFragment();
            }

            if (position==0) {
                return new CallsFragment();
            }
            return null;

        }




        @Override
        public int getCount() {
            return tabTiles.length ;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTiles[position];

        }
    }
}