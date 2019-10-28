package com.example.watchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.watchu.Activity.BaseActivity;
import com.example.watchu.Activity.LoginActivity;
import com.example.watchu.api.Api;
import com.example.watchu.domain.Image;
import  com.example.watchu.adapter.imageAdapter;
import com.example.watchu.domain.response.ListResponse;
import com.example.watchu.util.Constants;
import com.example.watchu.util.SharedPreferencesUtil;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {


    private imageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv= findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);


      /*  ArrayList<Image> datas=new ArrayList<>();
                 for (int i = 1; i < 10; i++) {
                //自己上传到服务器的图片地址
                  datas.add(new Image(String.format("http://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg",i)));
              }

              adapter.setDatas(datas);
*/

        adapter = new imageAdapter(this);
        rv.setAdapter(adapter);
        fetchData();

    }

        private void fetchData(){
            Api
                    .getInstance()
                    .images()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ListResponse<Image>>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ListResponse<Image> imageListResponse) {
                            //当数据请求完成之后，他会解析成java对象，并返回给我们
                            //真实项目中还会进行一系列的错误处理
                            adapter.setData(imageListResponse.getData());
                        }

                        @Override
                        public void onError(Throwable e) {
                            //把错误写到日志
                            e.printStackTrace();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
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
