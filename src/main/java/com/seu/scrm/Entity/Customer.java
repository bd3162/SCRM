package com.seu.scrm.Entity;

public class Customer {
    private String user_id;
    private String  verif;
    private String open_id;
    private int memb_points;
    private String city;
    private int gender;
    //性别：1代表男,非1代表女,不考虑其他特殊情况
    private String avatarUrl;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVerif() {
        return verif;
    }

    public void setVerif(String verif) {
        this.verif = verif;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getMemb_points() {
        return memb_points;
    }

    public void setMemb_points(int memb_points) {
        this.memb_points = memb_points;
    }
}
