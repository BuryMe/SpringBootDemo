package com.example.demo.futuer2;

import com.example.demo.futuer.*;

/**
 * Created by constanting on 2018/7/7.
 */
public class FutuerData implements Data{

    private RealData realData;
    private Boolean isReady = false;

    @Override
    public synchronized String getData() {
        while (!isReady){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return this.realData.getData();
    }

    //通知
    public synchronized void setRealData(RealData realData){
        if(isReady){
            return ;
        }
        isReady = true;
        this.realData = realData;
        notifyAll();
    }
}
