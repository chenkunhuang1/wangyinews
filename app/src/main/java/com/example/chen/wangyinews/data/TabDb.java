package com.example.chen.wangyinews.data;

import com.example.chen.wangyinews.fragment.JokeFragment;
import com.example.chen.wangyinews.fragment.NewFragment;

/**
 * Created by chen on 2017/5/25.
 */

public class TabDb {
    /***
     * 获得底部所有项
     */
    public static String[] getTabsTxt() {
        String[] tabs = {"首页","笑话大全"};
        return tabs;
    }
    /***
     * 获得所有碎片
     */
    public static Class[] getFramgent(){
        Class[] cls = {NewFragment.class,JokeFragment.class};
        return cls ;
    }
}
