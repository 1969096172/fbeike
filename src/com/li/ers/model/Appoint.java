package com.li.ers.model;

public class Appoint {
    private int appointid;
//预约时间
    private String appointdata;
//当前时间
    private String appointtime;
//电话
    private String appointtel;
//状态
    private int appointstate;
//用户id
    private int userid;
//房源id
    private int houseid;

    public int getAppointid() {
        return appointid;
    }

    public void setAppointid(int appointid) {
        this.appointid = appointid;
    }

    public String getAppointdata() {
        return appointdata;
    }

    public void setAppointdata(String appointdata) {
        this.appointdata = appointdata;
    }

    public String getAppointtime() {
        return appointtime;
    }

    public void setAppointtime(String appointtime) {
        this.appointtime = appointtime;
    }

    public String getAppointtel() {
        return appointtel;
    }

    public void setAppointtel(String appointtel) {
        this.appointtel = appointtel;
    }

    public int getAppointstate() {
        return appointstate;
    }

    public void setAppointstate(int appointstate) {
        this.appointstate = appointstate;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }
}
