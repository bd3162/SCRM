package com.seu.scrm.dto;

public class HotRequest {

    /**
     * 选择统计的时间
     * */
    private Integer period;

    /**
     * 设计维度
     * */
    private String statisDimens;

    /**
     * 统计的子类别的数量
     * */
    private Integer subNum;


    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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
        return "HotRequest{" +
                "period=" + period +
                ", statisDimens='" + statisDimens + '\'' +
                ", subNum=" + subNum +
                '}';
    }
}
