package com.example.chen.wangyinews.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chen.wangyinews.R;
import com.example.chen.wangyinews.adapter.JokeAdapter;
import com.example.chen.wangyinews.data.JokeData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by chen on 2017/5/25.
 */

public class JokeFragment extends Fragment {
    private RecyclerView mJokeRecycleView;
    private JokeAdapter mAdapter;
    private Handler mHandler;
    private List<JokeData.ResultBean.DataBean> mList = new ArrayList<>();
    private static final int MSG_GET_JOKE = 1002;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jokefragment,container,false);
        getData();
        initHandler();
        mJokeRecycleView = (RecyclerView) view.findViewById(R.id.joke_recyclerview);
        mAdapter = new JokeAdapter(mList);
        mJokeRecycleView.setAdapter(mAdapter);
        mJokeRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void initHandler() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_GET_JOKE){
                    mAdapter.changeData(mList);
                }
                return false;
            }
        });
    }

    private void getData() {
        String url = "http://japi.juhe.cn/joke/content/list.from?key=7a979503b290b4ed8d3d30c219827280&page=2&pagesize=10&sort=asc&time=1418745237";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AA",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                JokeData data = gson.fromJson(response.body().string(),JokeData.class);
                mList = data.getResult().getData();
                mHandler.sendEmptyMessage(MSG_GET_JOKE);
            }
        });
    }


}
