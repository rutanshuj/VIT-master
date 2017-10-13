package com.example.user.vit.activities;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.vit.R;
import com.example.user.vit.fragment.TodayFragment;
import com.example.user.vit.fragment.UpFragment;

import java.util.zip.Inflater;

public class Home1 extends Fragment {
    public static ViewPager viewPager;
    public static TabLayout tabLayout;
    public static int swipe_item = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home1, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return v;
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: return new UpFragment();
                case 1: return new TodayFragment();
                default: return new UpFragment();
            }
        }

        @Override
        public int getCount() {
            return swipe_item;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "              Upcoming         ";
                case 1: return "              Today            ";
            }
            return null;
        }
    }
}
