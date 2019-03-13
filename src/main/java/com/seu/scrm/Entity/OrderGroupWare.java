package com.seu.scrm.Entity;

/**
 * 每个订单对应一个OrderGroupWare类
 */
public class OrderGroupWare {
    private String prod_asin;
    //单价
    private  double price;
    private  int num;
    private  String title;
    //总付款
    private  double tatolPrice;
    private int unix_time;
    private String imUrl;

    public String getImUrl() {
        return imUrl;
    }

    public void setImUrl(String imUrl) {
        this.imUrl = imUrl;
    }

    public int getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(int unix_time) {
        this.unix_time = unix_time;
    }

    public String getProd_asin() {
        return prod_asin;
    }

    public void setProd_asin(String prod_asin) {
        this.prod_asin = prod_asin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTatolPrice() {
        return tatolPrice;
    }

    public void setTatolPrice(double tatolPrice) {
        this.tatolPrice = tatolPrice;
    }
}
