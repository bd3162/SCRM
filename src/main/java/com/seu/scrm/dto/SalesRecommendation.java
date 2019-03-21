package com.seu.scrm.dto;

import java.util.List;

/**
 * Created by chenxiaosuo on 2019/3/20.
 */
public class SalesRecommendation {

    private  UserInfo userInfo;

    private List<ProductInfo> productsList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<ProductInfo> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductInfo> productsList) {
        this.productsList = productsList;
    }

    public SalesRecommendation() {
    }

    public SalesRecommendation(UserInfo userInfo, List<ProductInfo> productsList) {
        this.userInfo = userInfo;
        this.productsList = productsList;
    }
}
