package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * <p>
 * 一组品牌销售统计数据
 */
public class BrandSales extends Sales{

    public BrandSales(String brand) {
        this.brand = brand;
    }

    /*
        * 品牌名称

        * */
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
