package com.example.chen.wangyinews.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.chen.wangyinews.R;
import com.example.chen.wangyinews.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private List<View> mViewList;
    private ViewPagerAdapter mPagerAdapter;
    private ViewPager mviewpager;
    private ImageView[] dots;
    private Button mstart_btn;
    private int[] ids = {R.id.iv1,R.id.iv2,R.id.iv3};
    private ImageView miv_close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initDots();
    }

    private void initDots() {
        dots = new ImageView[mViewList.size()];
        for (int i = 0; i < mViewList.size(); i++) {
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    private void initView() {
        LayoutInflater inflate = LayoutInflater.from(this);
        mViewList = new ArrayList<View>();
        mViewList.add(inflate.inflate(R.layout.one,null));
        mViewList.add(inflate.inflate(R.layout.two,null));
        mViewList.add(inflate.inflate(R.layout.three,null));
        mPagerAdapter = new ViewPagerAdapter(mViewList,this);
        mviewpager = (ViewPager) findViewById(R.id.viwepage);
        mviewpager.setAdapter(mPagerAdapter);
        mstart_btn = (Button) mViewList.get(2).findViewById(R.id.start_btn);
        mstart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        miv_close = (ImageView) findViewById(R.id.iv_close);
        miv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        //添加回调函数
        mviewpager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < ids.length; i++) {
            if (position == i){
                dots[i].setImageResource(R.drawable.login_point_selected);
            }else{
                dots[i].setImageResource(R.drawable.login_point);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
