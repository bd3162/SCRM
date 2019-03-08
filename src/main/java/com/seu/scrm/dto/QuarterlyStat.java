package com.seu.scrm.dto;

import java.util.List;

public class QuarterlyStat {
    /*
     *  报表类型，为"quarterly"
     * */
    private String reportType;


    /*
     *  统计的维度
     * */
    private String statisDimens;

    /*
     *  购买的品牌统计数据
     * */
    private List<List<ProductSales>> productSalesList;

    /*
     *  购买的类别统计数据
     * */
    private List<List<CategorySales>> categorySalesList;

    /*
     *  购买的产品统计数据
     * */
    private List<List<Sales>> totalSalesList;

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getStatisDimens() {
        return statisDimens;
    }

    public void setStatisDimens(String statisDimens) {
        this.statisDimens = statisDimens;
    }

    public List<List<ProductSales>> getProductSalesList() {
        return productSalesList;
    }

    public void setProductSalesList(List<List<ProductSales>> productSalesList) {
        this.productSalesList = productSalesList;
    }

    public List<List<CategorySales>> getCategorySalesList() {
        return categorySalesList;
    }

    public void setCategorySalesList(List<List<CategorySales>> categorySalesList) {
        this.categorySalesList = categorySalesList;
    }

    public List<List<Sales>> getTotalSalesList() {
        return totalSalesList;
    }

    public void setTotalSalesList(List<List<Sales>> totalSalesList) {
        this.totalSalesList = totalSalesList;
    }
}
