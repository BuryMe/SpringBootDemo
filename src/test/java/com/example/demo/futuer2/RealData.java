package com.example.demo.futuer2;

/**
 * Created by constanting on 2018/7/7.
 */
public class RealData implements Data{

    private String result;

    public RealData(String request){
        System.out.println("开始模拟实际业务操作，请求数据为"+request);
        for (int i = 0; i < 5; i++) {
            System.out.println("数据处理流程"+i);
        }
        this.result = "实际数据处理结果";
    }

    @Override
    public String getData() {
        return result;
    }
}
