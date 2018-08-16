package com.example.expection;

import lombok.extern.slf4j.Slf4j;

/**
 * 业务异常类
 * Created by constanting on 2018/7/1.
 */
@Slf4j
public class BussinessExpection extends Exception{

    private static final long serialVersionUID = -5519743897907627214L;
    private String code;
    private String msg;

    public String getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    public BussinessExpection(){
        super();
    }

    public BussinessExpection(String ExpectionMsg){
        super(ExpectionMsg);
        this.print();
    }

    public BussinessExpection(String code, String msg){
        this.code = code;
        this.msg = msg;
        this.print();
    }

    public void print(){
        log.error("异常代码:{},异常描述:{}：",this.code,this.msg);
    }


}
