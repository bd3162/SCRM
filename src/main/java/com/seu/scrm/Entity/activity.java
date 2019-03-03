package com.seu.scrm.Entity;

public class activity {
    private int id;
    private String activ_title;
    private String activ_img;
    private String activ_desc;
    private String start_time;
    private String end_time;

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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
