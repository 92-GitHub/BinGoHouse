package com.example.watchu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.text.*;
import com.example.watchu.R;
import com.example.watchu.util.Constants;
import com.example.watchu.util.RegexUtil;
import android.content.Intent;
import  com.example.watchu.util.SharedPreferencesUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_password;
    private SharedPreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        Button bt_login=findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);

        sp = SharedPreferencesUtil.getInstance(getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                login();
                break;
        }
    }

    private void login() {
        //需要把et_username和et_password转换为实例变量,才能在这个方法中访问
        String username=et_username.getText().toString().trim();

        //判断是否输入了邮箱
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,R.string.email_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //通过正则表达式判断邮箱格式是否正确
        if(!RegexUtil.isEmail(username)){
            Toast.makeText(this,R.string.email_error,Toast.LENGTH_SHORT).show();
            return;
        }

        String password=et_password.getText().toString().trim();

        //判断是否输入了密码
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.password_hint,Toast.LENGTH_SHORT).show();
            return;
        }

        //判断密码长度是否符合要求
        if(password.length()<6 ||password.length()>15){
            Toast.makeText(this,R.string.password_length_error,Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO 在这里就调用服务器端的登陆接口
        //我们这里是把密码和用户名写在本地
        if(Constants.username.equals(username)&&Constants.password.equals(password)){
            //TODO 通常软件的做法是在登陆成功之后保存一个标志，下次进入软件就不用再登陆了
            //登陆成功之后进入首页
            sp.setLogin(true);//保存登陆标志

            Intent intent=new Intent(this,com.example.watchu.MainActivity.class);
            startActivity(intent);

            finish();
        }
        else {
            //登陆失败，进行提示
            Toast.makeText(this,R.string.username_or_password_error,Toast.LENGTH_SHORT).show();
        }
    }
}
