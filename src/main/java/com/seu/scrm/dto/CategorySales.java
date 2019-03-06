package com.seu.scrm.dto;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 一组类别销售统计数据
 */
public class CategorySales extends Sales{

    /*
    * 品牌名称
    * */
    private String category;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
