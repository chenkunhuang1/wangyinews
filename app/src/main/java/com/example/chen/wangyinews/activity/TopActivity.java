package com.example.chen.wangyinews.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.chen.wangyinews.R;
import com.example.chen.wangyinews.adapter.TopAdapter;
import com.example.chen.wangyinews.fragment.JokeFragment;
import com.example.chen.wangyinews.fragment.MainFragment;
import com.example.chen.wangyinews.fragment.MyFragment;
import com.example.chen.wangyinews.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class TopActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<Fragment> list_fragment = new ArrayList<>();
    private TopAdapter mAdapter;
    private TextView mnews_tab;
    private TextView mjoke_tab;
    private TextView mweather_tab;
    private TextView mmy_tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        initTopFragement();
        initBottomViews();

        mAdapter = new TopAdapter(getSupportFragmentManager(),list_fragment);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initBottomViews() {
        mnews_tab = (TextView) findViewById(R.id.news_tab);
        mjoke_tab = (TextView) findViewById(R.id.joke_tab);
        mweather_tab = (TextView) findViewById(R.id.weather_tab);
        mmy_tab = (TextView) findViewById(R.id.my_tab);
        mnews_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
                mnews_tab.setTextColor(Color.RED);
                mnews_tab.setTextSize(30);
                mjoke_tab.setTextColor(Color.BLUE);
                mjoke_tab.setTextSize(20);
                mweather_tab.setTextColor(Color.BLUE);
                mweather_tab.setTextSize(20);
                mmy_tab.setTextColor(Color.BLUE);
                mmy_tab.setTextSize(20);
            }
        });
        mjoke_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1);
                mnews_tab.setTextColor(Color.BLUE);
                mnews_tab.setTextSize(20);
                mjoke_tab.setTextColor(Color.RED);
                mjoke_tab.setTextSize(30);
                mweather_tab.setTextColor(Color.BLUE);
                mweather_tab.setTextSize(20);
                mmy_tab.setTextColor(Color.BLUE);
                mmy_tab.setTextSize(20);
            }
        });
        mweather_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(2);
                mnews_tab.setTextColor(Color.BLUE);
                mnews_tab.setTextSize(20);
                mjoke_tab.setTextColor(Color.BLUE);
                mjoke_tab.setTextSize(20);
                mweather_tab.setTextColor(Color.RED);
                mweather_tab.setTextSize(30);
                mmy_tab.setTextColor(Color.BLUE);
                mmy_tab.setTextSize(20);
            }
        });
        mmy_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(3);
                mnews_tab.setTextColor(Color.BLUE);
                mnews_tab.setTextSize(20);
                mjoke_tab.setTextColor(Color.BLUE);
                mjoke_tab.setTextSize(20);
                mweather_tab.setTextColor(Color.BLUE);
                mweather_tab.setTextSize(20);
                mmy_tab.setTextColor(Color.RED);
                mmy_tab.setTextSize(30);
            }
        });
    }

    private void initTopFragement() {
        mViewPager = (ViewPager) findViewById(R.id.top_viewPager);
        MainFragment mf = new MainFragment();
        list_fragment.add(mf);

        JokeFragment jf = new JokeFragment();
        list_fragment.add(jf);

        WeatherFragment wf = new WeatherFragment();
        list_fragment.add(wf);

        MyFragment mmy = new MyFragment();
        list_fragment.add(mmy);

    }
}
