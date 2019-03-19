package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 */
public class ReportResult<T> {
    private int msgCode;

    private T data;

    private String msgDesc;

    public ReportResult() {
    }

    public ReportResult(int status, T data, String msg) {
        this.msgCode = status;
        this.data = data;
        this.msgDesc = msg;
    }

    public ReportResult(int status, String msg) {
        this.msgCode = status;
        this.msgDesc = msg;
    }

    public ReportResult(String msg) {
        this.msgDesc = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    @Override
    public String toString() {
        return "ReportResult{" +
                "msgCode=" + msgCode +
                ", data=" + data +
                ", msgDesc='" + msgDesc + '\'' +
                '}';
    }
}
