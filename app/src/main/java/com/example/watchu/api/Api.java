package com.example.watchu.api;

import androidx.appcompat.app.AppCompatActivity;

import com.example.watchu.domain.Image;
import com.example.watchu.domain.response.ListResponse;
import com.example.watchu.util.Constants;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api instance;
    private final Service service;

    //创建okhttp，配置
    Api(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();

        //创建retrofit
        Retrofit retrofit=new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(Constants.ENDPOINT)//配置API地址
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
    }


    public static Api getInstance(){
        if (instance ==null){
            instance=new Api();
        }
        return instance;
    }

    public Observable<ListResponse<Image>> images(){
        /**调用service里面的方法
         * service是一个接口
         * 我们在这里调用接口之所以能返回数据
         * 是因为retrofit框架内部帮我们处理了该方法的调用
         */
        return service.images();
    }
}
