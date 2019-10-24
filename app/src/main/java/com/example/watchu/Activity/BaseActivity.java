package com.example.watchu.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.watchu.util.SharedPreferencesUtil;

public class BaseActivity extends AppCompatActivity {

    protected SharedPreferencesUtil sp;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        //配置文件
        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
        //其他的公共逻辑都可以这样使用，这样设置之后，只要是子类使用了父类的这个方法，就可以使用sp这个变量
    }
}
