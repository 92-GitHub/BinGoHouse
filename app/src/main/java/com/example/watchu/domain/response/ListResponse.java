package com.example.watchu.domain.response;

import java.util.List;

//用来解析从网络请求得到的数据
public class ListResponse<T>{
    private List<T> data;

    public List<T> getData(){
        return data;
    }

    public void setData(List<T> data){
        this.data=data;
    }
}
