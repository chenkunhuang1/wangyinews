package com.example.chen.wangyinews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.chen.wangyinews.R;

/**
 * Created by chen on 2017/5/25.
 */
public class JokeViewHolder extends RecyclerView.ViewHolder{
    TextView jokeview;
    public JokeViewHolder(View itemView) {
        super(itemView);
        jokeview = (TextView) itemView.findViewById(R.id.joke_tv);
    }
}
