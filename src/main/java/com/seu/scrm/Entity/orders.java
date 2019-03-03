package com.seu.scrm.Entity;

public class orders {
    private String user_id;
    private String prod_asin;
    private int rate;
    private int unix_time;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProd_asin() {
        return prod_asin;
    }

    public void setProd_asin(String prod_asin) {
        this.prod_asin = prod_asin;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getUnix_time() {
        return unix_time;
    }

    public void setUnix_time(int unix_time) {
        this.unix_time = unix_time;
    }
}
