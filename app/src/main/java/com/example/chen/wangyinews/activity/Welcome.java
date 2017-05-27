package com.example.chen.wangyinews.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.chen.wangyinews.R;

public class Welcome extends AppCompatActivity {
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
    private static final int TIME = 2000;
    private boolean isFirstIn = false;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    goHome();
                    break;
                case GO_GUIDE:
                    goGuide();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }
    private void init(){
        SharedPreferences sharedPreferences = getSharedPreferences("share",MODE_PRIVATE);
        isFirstIn = sharedPreferences.getBoolean("isFirstIn",true);
        if (!isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_HOME,TIME);
        }else{
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,TIME);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirstIn",false);
            editor.commit();
        }
    }
    private void goHome(){
        Intent i = new Intent(Welcome.this,TopActivity.class);
        startActivity(i);
        finish();
    }
    private void goGuide(){
        Intent i = new Intent(Welcome.this,GuideActivity.class);
        startActivity(i);
        finish();
    }


}
