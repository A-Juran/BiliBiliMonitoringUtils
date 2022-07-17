package com.juran.bFans.utils.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 作者： Juran on 2022-07-17 10:27
 * 作者博客：iit.la
 */
public class HttpUtil {
    //请求api
    public static String send(String url) throws IOException {
       //创建连接
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建请求Method
        HttpGet httpGet = new HttpGet(url);
        //设置请求头参数
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
        //执行请求获取响应
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
             //获取响应实体
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            //打印获取内容
            return result;
        }
    }
}
