package com.seu.scrm.Entity;

public class Prodcate {
    private String product_asin; // 商品ID
    private String category; // 细分类别

    public String getProduct_asin() {
        return product_asin;
    }

    public void setProduct_asin(String product_asin) {
        this.product_asin = product_asin;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
