package com.example.chen.wangyinews.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.chen.wangyinews.Inter.OnClickEvent;

import java.util.List;

/**
 * Created by chen on 2017/5/16.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private List<View> mViews;
    private Context mContext;

    public ViewPagerAdapter(List<View> mViews,Context mContext){
        this.mViews = mViews;
        this.mContext = mContext;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object) ;
    }
}
