package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 一组价格区间销售数据
 */
public class PriceSales extends Sales {

    /*
* 价格区间起始
* */
    private Integer startPrice;

    /*
* 价格区间结束
* */
    private Integer endPrice;


    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }
}
