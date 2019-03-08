package com.seu.scrm.dto;

public class QuarterlyRequest {

    /**
     * 查询年份信息
     * */
    private String year;

    /**
     * 统计维度
     * */
    private String statisDimens;

    /**
     * 统计维度的参数
     * */
    private String dimensParam;

    /**
     * 统计的子类别类型
     * */
    private String subType;

    /**
     * 统计的子类别的数量
     * */
    private Integer subNum;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatisDimens() {
        return statisDimens;
    }

    public void setStatisDimens(String statisDimens) {
        this.statisDimens = statisDimens;
    }


    public String getDimensParam() {
        return dimensParam;
    }

    public void setDimensParam(String dimensParam) {
        this.dimensParam = dimensParam;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Integer getSubNum() {
        return subNum;
    }

    public void setSubNum(Integer subNum) {
        this.subNum = subNum;
    }

    @Override
    public String toString() {
        return "QuarterlyRequest{" +
                "year='" + year + '\'' +
                ", statisDimens='" + statisDimens + '\'' +
                ", subType='" + subType + '\'' +
                ", subNum=" + subNum +
                '}';
    }
}
