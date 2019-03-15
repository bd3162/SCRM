package com.seu.scrm.Entity;

public class Personal_recom {
    private String user_id;
    private String prod_asin;
    private double rank;
    private int update_time;

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

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public int getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(int update_time) {
        this.update_time = update_time;
    }
}
