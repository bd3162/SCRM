package com.seu.scrm.dto;

import java.util.List;

/**
 * Created by chenxiaosuo on 2019/3/6.
 * 按照用户id去查询用户购买信息的统计数据返回结果
 */
public class PersonalStat {

    /*
    *  报表类型，为"person"
    * */
    private String reportType;

    /*
    *  查询的用户id信息
    * */
    private String userId;

    /*
    *  统计的维度
    * */
    private String statisDimens;

    /*
    *  购买的品牌统计数据
    * */
    private List<List<BrandSales>> brandSalesList;

    /*
*  购买的类别统计数据
* */
    private List<List<CategorySales>> categorySalesList;

    /*
*  购买的产品统计数据
* */
    private List<List<ProductSales>> productSalesList;

    /*
*  购买的时间统计数据
* */
    private List<List<Sales>> timeSalesList;

    /*
*  购买的价格区间统计数据
* */
    private List<List<PriceSales>> priceSalesList;


    public PersonalStat(String userId) {
        this.userId = userId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatisDimens() {
        return statisDimens;
    }

    public void setStatisDimens(String statisDimens) {
        this.statisDimens = statisDimens;
    }

    public List<List<BrandSales>> getBrandSalesList() {
        return brandSalesList;
    }

    public void setBrandSalesList(List<List<BrandSales>> brandSalesList) {
        this.brandSalesList = brandSalesList;
    }

    public List<List<CategorySales>> getCategorySalesList() {
        return categorySalesList;
    }

    public void setCategorySalesList(List<List<CategorySales>> categorySalesList) {
        this.categorySalesList = categorySalesList;
    }

    public List<List<ProductSales>> getProductSalesList() {
        return productSalesList;
    }

    public void setProductSalesList(List<List<ProductSales>> productSalesList) {
        this.productSalesList = productSalesList;
    }

    public List<List<Sales>> getTimeSalesList() {
        return timeSalesList;
    }

    public void setTimeSalesList(List<List<Sales>> timeSalesList) {
        this.timeSalesList = timeSalesList;
    }

    public List<List<PriceSales>> getPriceSalesList() {
        return priceSalesList;
    }

    public void setPriceSalesList(List<List<PriceSales>> priceSalesList) {
        this.priceSalesList = priceSalesList;
    }
}
