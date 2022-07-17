package com.juran.bFans.api;

/**
 * 作者： Juran on 2022-07-17 10:24
 * 作者博客：iit.la
 */
public enum ApiManager {
    //此处设置自己的  idvmid=382365363
    BILIBILI_GET_FANS("https://api.bilibili.com/x/relation/stat?vmid=382365363&jsonp=jsonp");
    private String api;

    ApiManager(String api) {
        this.api = api;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
