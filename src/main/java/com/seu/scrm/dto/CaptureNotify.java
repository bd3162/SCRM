package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/19.
 */
public class CaptureNotify {
    String userId;

    Integer isOld;

    Integer captureTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getIsOld() {
        return isOld;
    }

    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    public Integer getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Integer captureTime) {
        this.captureTime = captureTime;
    }

    @Override
    public String toString() {
        return "CaptureNotify{" +
                "userId='" + userId + '\'' +
                ", isOld=" + isOld +
                ", captureTime=" + captureTime +
                '}';
    }
}
