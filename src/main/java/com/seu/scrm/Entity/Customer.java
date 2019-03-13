package com.seu.scrm.Entity;

public class Customer {
    private String user_id;
    private String  verif;
    private String open_id;
    private int memb_points;

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
