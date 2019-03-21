package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/20.
 */
public class UserInfo {
    private  String userId;

    private  String imgUrl;

    private  Integer isMember;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIsMember() {
        return isMember;
    }

    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    public UserInfo(String userId, String imgUrl, Integer isMember) {
        this.userId = userId;
        this.imgUrl = imgUrl;
        this.isMember = isMember;
    }

    public UserInfo() {
    }
}
