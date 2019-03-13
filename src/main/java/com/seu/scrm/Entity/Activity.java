package com.seu.scrm.Entity;

public class Activity {
    private int id;
    private String activ_title;
    private String activ_img;
    private String activ_desc;
    private int  start_date;
    private int  end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActiv_title() {
        return activ_title;
    }

    public void setActiv_title(String activ_title) {
        this.activ_title = activ_title;
    }

    public String getActiv_img() {
        return activ_img;
    }

    public void setActiv_img(String activ_img) {
        this.activ_img = activ_img;
    }

    public String getActiv_desc() {
        return activ_desc;
    }

    public void setActiv_desc(String activ_desc) {
        this.activ_desc = activ_desc;
    }

    public int getStart_date() {
        return start_date;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }
}
