package com.seu.scrm.Entity;

import java.util.Date;

public class QuarterlyProductStats extends QuarterlyProductStatsKey {
    private Integer salesCount;

    private Integer salesAmount;

    private Date countTime;

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }
}