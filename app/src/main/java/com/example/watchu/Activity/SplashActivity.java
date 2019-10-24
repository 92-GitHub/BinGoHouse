package com.example.watchu.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;

import android.content.Intent;
import com.example.watchu.MainActivity;
import com.example.watchu.R;
import com.example.watchu.util.SharedPreferencesUtil;


public class SplashActivity extends AppCompatActivity {

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            next();
        }
    };
    private SharedPreferencesUtil sp;

    private void next() {
        Intent intent=null;
        if (sp.isLogin()){
            intent=new Intent(this,MainActivity.class);
        }
        else {
            intent=new Intent(this,LoginActivity.class);
        }
        startActivity(intent);

        finish();//关闭当前界面
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //3秒钟后调用这里
                //这里是在调用子线程，不能直接操纵ui，需要用handler切换到主线程
                //用多个线程的目的是，把耗时任务放在子线程里，那么主线程就不会出现卡住的情况
                handler.sendEmptyMessage(0);
            }
        },3000);
    }
}
