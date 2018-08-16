package com.example.demo.futuer;

/**
 * Created by constanting on 2018/7/7.
 */
public class FutuerData implements Data{

    private RealData realData;
    private Boolean isReady = false;

    public synchronized String getData(){
        while (!isReady){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return this.realData.getData();
    }

    public synchronized void setData(RealData realData){
        if (isReady){
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }


}
