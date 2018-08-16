package com.example.domain.common;

/**
 * 请求数据封装类
 */
public class RequestBo {

    /**
     * 请求服务名称
     */
    private String serviceName;

    /**
     * 请求报文数据
     */
    private String reqData;

    /**
     * 请求时间戳
     */
    private String reqTimestamp;

    /**
     * 请求流水号
     */
    private String reqSerialNo;

    /**
     * 请求报文数据（附件）
     */
    private String additionData;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getReqData() {
        return reqData;
    }

    public void setReqData(String reqData) {
        this.reqData = reqData;
    }

    public String getReqTimestamp() {
        return reqTimestamp;
    }

    public void setReqTimestamp(String reqTimestamp) {
        this.reqTimestamp = reqTimestamp;
    }

    public String getReqSerialNo() {
        return reqSerialNo;
    }

    public void setReqSerialNo(String reqSerialNo) {
        this.reqSerialNo = reqSerialNo;
    }

    public String getAdditionData() {
        return additionData;
    }

    public void setAdditionData(String additionData) {
        this.additionData = additionData;
    }
}
