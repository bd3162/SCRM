package com.seu.scrm.Entity;

public class QuarterlyTotalStatsKey {
    private String year;

    private Integer quarter;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }
}