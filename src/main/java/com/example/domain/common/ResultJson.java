package com.example.domain.common;

import lombok.Data;

import java.util.Map;

/**
 * 返回封装类
 */
@Data
public class ResultJson {

    private String code;

    private String msg;

    private Map<Object,Object> resData;

}
