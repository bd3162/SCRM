package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 一组销售数据
 */
public class Sales {

    /*
* 销售金额
* */
    private Integer salesAmount;

    /*
    * 销售数量
    * */
    private Integer salesCount;

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }
}
