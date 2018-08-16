package com.example.demo.futuer2;

/**
 * Created by constanting on 2018/7/7.
 */
public class FutuerClient {

    public Data getResponse(final String request){
        final FutuerData futuerData = new FutuerData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(request);
                futuerData.setRealData(realData);
            }
        }).start();
        return futuerData;
    }

    public static void main(String[] args) {
        FutuerClient futuerClient = new FutuerClient();
        System.out.println("开始处理业务");
        Data data = futuerClient.getResponse("test reauest");
        System.out.println("假数据（或者做别的事）");
        System.out.println(data.getData());
    }
}
