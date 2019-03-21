package com.seu.scrm.Utils;

/**
 * Created by chenxiaosuo on 2019/3/20.
 */
public enum  MsgCode {
    SERVICE_OK(0, "Success")
    ,DB_UPDATE_FAILURE(1001, "更新数据库失败")
    ;


    private String msg;
    private int code;

    private MsgCode(int code, String msg) {
        this.code = code;
        this.msg =msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
