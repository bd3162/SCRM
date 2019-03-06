package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 一组商品销售数据统计
 */
public class ProductSales extends Sales{
    /*
* 商品名称
* */
    private String product;


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
