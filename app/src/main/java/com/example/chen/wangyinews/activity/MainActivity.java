package com.example.chen.wangyinews.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chen.wangyinews.R;
import com.example.chen.wangyinews.adapter.FragmentAdapter;
import com.example.chen.wangyinews.fragment.NewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout_t;
    private ViewPager mViewPager;
    List<Fragment> fragments = new ArrayList<>();
    /*private List<NewFragment> mNewFragmentList = new ArrayList<NewFragment>();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        initViewPager();

    }

    private void initViewPager() {
        mTabLayout_t = (TabLayout) findViewById(R.id.sliding_tabtop);
        List<String> titles = new ArrayList<>();
        titles.add("头条");
        titles.add("社会");
        titles.add("国际");
        titles.add("国内");
        titles.add("娱乐");
        titles.add("体育");
        titles.add("军事");
        titles.add("科技");
        titles.add("财经");
        titles.add("时尚");
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout_t.addTab(mTabLayout_t.newTab().setText(titles.get(i)));
        }

        initFragmentArrayList();
        /*for (int i = 0; i < titles.size(); i++) {
            fragments.add(fragments.get(i));
        }*/
        /*fragments.add(mNewFragmentList.get(0));
        fragments.add(mNewFragmentList.get(1));
        fragments.add(mNewFragmentList.get(2));
        fragments.add(mNewFragmentList.get(3));*/
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        //给ViewPage设置适配器
        mViewPager.setAdapter(mFragmentAdapter);
        //将mViewPage与mTabLayout关联
        mTabLayout_t.setupWithViewPager(mViewPager);
        /*//给TabLayout设置适配器
        mTabLayout_t.setTabsFromPagerAdapter(mFragmentAdapter);*/
    }
    private void initFragmentArrayList(){
        NewFragment fa = new NewFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("NEWSTYPE",1);
        fa.setArguments(bundle1);

        NewFragment fb = new NewFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("NEWSTYPE",2);
        fb.setArguments(bundle2);

        NewFragment fc = new NewFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("NEWSTYPE",3);
        fc.setArguments(bundle3);

        NewFragment fd = new NewFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("NEWSTYPE",4);
        fd.setArguments(bundle4);

        NewFragment fe = new NewFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putInt("NEWSTYPE",5);
        fe.setArguments(bundle5);

        NewFragment ff = new NewFragment();
        Bundle bundle6 = new Bundle();
        bundle6.putInt("NEWSTYPE",6);
        ff.setArguments(bundle6);

        NewFragment fg = new NewFragment();
        Bundle bundle7 = new Bundle();
        bundle7.putInt("NEWSTYPE",7);
        fg.setArguments(bundle7);

        NewFragment fh = new NewFragment();
        Bundle bundle8 = new Bundle();
        bundle8.putInt("NEWSTYPE",8);
        fh.setArguments(bundle8);

        NewFragment fi = new NewFragment();
        Bundle bundle9 = new Bundle();
        bundle9.putInt("NEWSTYPE",9);
        fi.setArguments(bundle9);

        NewFragment fj = new NewFragment();
        Bundle bundle10 = new Bundle();
        bundle10.putInt("NEWSTYPE",10);
        fj.setArguments(bundle10);


        fragments.add(fa);
        fragments.add(fb);
        fragments.add(fc);
        fragments.add(fd);
        fragments.add(fe);
        fragments.add(ff);
        fragments.add(fg);
        fragments.add(fh);
        fragments.add(fi);
        fragments.add(fj);
    }
}
