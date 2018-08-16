package com.example.demo.futuerTask;

import java.util.concurrent.Callable;

/**
 * 线程执行体
 * Created by constanting on 2018/7/7.
 */
public class RealData implements Callable<String>{

    private String result;

    public RealData(String request){
        System.out.println("开始处理业务逻辑，请求数据为"+request);
        for (int i = 0; i < 3; i++) {
            try{
                Thread.sleep(1000);
                System.out.println("业务流程"+i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.result = "业务处理结果";
    }

    @Override
    public String call() throws Exception {
        return result;
    }
}
