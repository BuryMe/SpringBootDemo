package com.example.demo.futuer;

/**
 * Created by constanting on 2018/7/7.
 */
public class FutuerClient {

    public Data request(final String request){
        final FutuerData futuerData = new FutuerData();
        //实际处理子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(request);
                //通知
                futuerData.setData(realData);
            }
        }).start();
        return futuerData;
    }

    public static void main(String[] args) {
        FutuerClient futuerClient = new FutuerClient();
        Data data = futuerClient.request("hello.world");
        System.out.println("请求发送成功");
        //假通知
        System.out.println("去干其他事");
        //拿到实际处理结果
        String str = data.getData();
        System.out.println(str);
    }

}
