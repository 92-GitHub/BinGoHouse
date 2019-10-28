package com.example.watchu.domain;

public class Image {
    /**这里我们用来解析图片的数据*/
    private String uri;

    public Image(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
