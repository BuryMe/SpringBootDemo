package com.example.client;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.common.RequestBo;
import okhttp3.*;

import java.io.IOException;


/**
 * 模拟客户端
 */
public class simulateHttpClient {

    /**
     * HttpClient客户端
     */
    private static OkHttpClient okHttpClient = new OkHttpClient();

    /**
     * 设置json请求头
     */
    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");

    /**
     * Http Post请求(json)
     */
    public static void doPostWithJson(RequestBo requestBo)throws IOException{
        String reqJsonStr = JSONObject.toJSONString(requestBo);
        RequestBody body = RequestBody.create(JSON, reqJsonStr);
        Request request = new Request.Builder()
                //请求的url
                .url("http://172.20.192.168:8080/getbookByJson")
                .post(body)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String resStr = response.body().toString();
    }


}
