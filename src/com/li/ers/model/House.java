package com.li.ers.model;

public class House {
    private int houseid;
//名字
    private String jieshao;
//租房方式
    private String fangshi;
//    租金
    private double rent;
//朝向
    private String direction;
//租期
    private String period;
//地址
    private String detailaddress;
//状态
    private int status;
//楼层
    private String floor;
//电梯
    private String elevator;
//管理员id
    private int admind;
//几居id
    private int typeid;
//地区id
    private int areaid;
//图片1
    private String imgone;
//图片2
    private String imgtwo;
//图片3
    private String imgthree;

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }

    public String getJieshao() {
        return jieshao;
    }

    public void setJieshao(String jieshao) {
        this.jieshao = jieshao;
    }

    public String getFangshi() {
        return fangshi;
    }

    public void setFangshi(String fangshi) {
        this.fangshi = fangshi;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public int getAdmind() {
        return admind;
    }

    public void setAdmind(int admind) {
        this.admind = admind;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getImgone() {
        return imgone;
    }

    public void setImgone(String imgone) {
        this.imgone = imgone;
    }

    public String getImgtwo() {
        return imgtwo;
    }

    public void setImgtwo(String imgtwo) {
        this.imgtwo = imgtwo;
    }

    public String getImgthree() {
        return imgthree;
    }

    public void setImgthree(String imgthree) {
        this.imgthree = imgthree;
    }
}
