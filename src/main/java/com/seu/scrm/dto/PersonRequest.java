package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 获取个人统计数据请求实体
 * */
public class PersonRequest {

    /**
     * 用户ID
     * */
    private String userId;

    /**
     * 设计维度
     * */
    private String statisDimens;

    /**
     * 统计的子类别的数量
     * */
    private Integer subNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatisDimens() {
        return statisDimens;
    }

    public void setStatisDimens(String statisDimens) {
        this.statisDimens = statisDimens;
    }

    public Integer getSubNum() {
        return subNum;
    }

    public void setSubNum(Integer subNum) {
        this.subNum = subNum;
    }

    @Override
    public String toString() {
        return "PersonRequest{" +
                "userId='" + userId + '\'' +
                ", statisDimens='" + statisDimens + '\'' +
                ", subNum='" + subNum + '\'' +
                '}';
    }
}
