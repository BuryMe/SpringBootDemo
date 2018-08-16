package com.example.domain.common;

import com.alibaba.fastjson.JSONObject;
import com.example.util.JsonUtil;
import lombok.Data;

import java.util.Map;

/**
 * 响应返回封装类
 */
@Data
public class ResponseBo {

    /**
     * 返回响应报文
     */
    private String message;

    /**
     * 返回响应编码
     */
    private String code;

    /**
     * 响应返回数据
     */
    private Object data;

    /**
     * 是否连接 成功
     */
    private Boolean isLink;

    public static class ResponseBoBuilder{
        private String msg;
        private String code;
        private Object data;
        private Boolean isLink;

        public ResponseBoBuilder(String msg,String code,Boolean isLink){
            this.code = code;
            this.msg = msg;
            this.isLink = isLink;
        }

        public ResponseBoBuilder addData(Object dataObj){
//            JSONObject jsonObject = JsonUtil.mapToJsonObj(dataMap);
            this.data = dataObj;
            return this;
        }

        public ResponseBoBuilder isLink(Boolean isLinf){
            this.isLink = isLinf;
            return this;
        }

        public ResponseBoBuilder(){

        }
    }

}
