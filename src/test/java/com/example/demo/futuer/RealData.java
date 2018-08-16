package com.example.demo.futuer;

/**
 * 真正的数据
 * Created by constanting on 2018/7/7.
 */
public class RealData implements Data{

    private String result;

    public RealData(String request) {
        //模拟实际业务逻辑处理
        System.out.println("正在根据请求数据"+request+"查询，这需要花一定的时间");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < 5;i++){
            try{
                Thread.sleep(1000);
                System.out.println("数据正在产生，正在进行流程"+i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("数据结果查询完毕");
        result =  "数据结果";
    }

    public String getData() {
        return result;
    }
}
