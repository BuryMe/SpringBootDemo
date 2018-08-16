package com.example.enums;

/**
 * 异常处理返回结果
 * Created by constanting on 2018/7/1.
 */
public enum ExpResultEnum{
    ;
    //信息编码
    private String resCode;
    //信息内容
    private String resMsg;

    ExpResultEnum(String code,String msg){
        this.resCode = code;
        this.resMsg = msg;
    }

    public String getResCode(){
        return resCode;
    }

    public String getResMsg(){
        return resMsg;
    }
}
