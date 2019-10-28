package com.example.watchu.api;

import com.example.watchu.domain.Image;
import com.example.watchu.domain.response.ListResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Service {
    /**获取图片列表
     * */
    @GET("v1/images")
     Observable<ListResponse<Image>> images();
}
