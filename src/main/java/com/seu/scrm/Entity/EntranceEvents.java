package com.seu.scrm.Entity;

import java.util.Date;

/**
 * Created by chenxiaosuo on 2019/3/19.
 */
public class EntranceEvents {

    private Integer id;

    private String userId;

    private Date time;

    private Integer isSent;

    private Integer isOld;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getIsSent() {
        return isSent;
    }

    public void setIsSent(Integer isSent) {
        this.isSent = isSent;
    }

    public Integer getIsOld() {
        return isOld;
    }

    public void setIsOld(Integer isOld) {
        this.isOld = isOld;
    }

    @Override
    public String toString() {
        return "EntranceEvents{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", time=" + time +
                ", isSent=" + isSent +
                ", isOld=" + isOld +
                '}';
    }
}
