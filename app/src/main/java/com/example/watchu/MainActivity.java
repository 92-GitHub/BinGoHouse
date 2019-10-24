package com.example.watchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.watchu.Activity.BaseActivity;
import com.example.watchu.Activity.LoginActivity;
import com.example.watchu.util.Constants;
import com.example.watchu.util.SharedPreferencesUtil;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogoutclick(View view) {
        sp.setLogin(false);
        //设置登陆状态为false
        //跳转到登陆界面
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}
