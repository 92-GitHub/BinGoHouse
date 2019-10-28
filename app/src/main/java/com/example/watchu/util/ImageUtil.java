package com.example.watchu.util;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.watchu.R;

public class ImageUtil {
    public static void show(Activity activity, ImageView imageView,String uri){
        RequestOptions options=getCommonRequestOptions();
        Glide.with(activity).load(uri).apply(options).into(imageView);
    }

    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options=new RequestOptions();
        //加载前占位图
        options.placeholder(R.drawable.load);
        //加载错误图
        options.error(R.drawable.load);
        options.centerCrop();

        return options;
    }
}
