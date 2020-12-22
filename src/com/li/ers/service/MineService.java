package com.li.ers.service;

import com.li.ers.dao.IMineDAO;
import com.li.ers.dao.impl.MineDAO;
import com.li.ers.model.*;

import java.util.List;

public class MineService {
    IMineDAO mineDAO = new MineDAO();
    public void add(String tel, String time, int userid, int fanid) {
        mineDAO.add(tel, time, userid, fanid);
    }

    public User getuser(int userid) {
        User user = mineDAO.getuser(userid);
        return user;
    }

    public List<Appoint> getappoint(int userid) {
        List<Appoint> appointList = mineDAO.getappoint(userid);
        return appointList;
    }

    public void overap(int op, int i) {
        mineDAO.overop(op, i);
    }

    public void tofix(String oldpw, String newpw) {
        mineDAO.tofix(oldpw, newpw);
    }

    public void addorder(String data, String time, double dqian, int userid, int fandido) {
        mineDAO.addorder(data, time, userid, fandido, dqian);
    }

    public List<Order> getorder(int userid) {
        List<Order> orderList = mineDAO.getorder(userid);
        return orderList;
    }

    public List<Appoint> getadappoint() {
        List<Appoint> appointList = mineDAO.getadappint();
        return appointList;
    }

    public List<User> gerusername(List<Appoint> appointList) {
        List<User> userList = mineDAO.getsusername(appointList);
        return userList;
    }

    public List<Housetype> getkind() {
        List<Housetype> housetypeList = mineDAO.getkind();
        return housetypeList;
    }

    public List<Area> getarea() {
        List<Area> areaList = mineDAO.getarea();
        return areaList;
    }

    public void addfang(int areaidx, String xiaoqu, int kindidx, String chaoxiang, String dianti, String building, double expectation_price, String fangshi, String zuqi, String addrdss) {
        mineDAO.addfang(areaidx, xiaoqu, kindidx, chaoxiang, dianti, building, expectation_price, fangshi, zuqi, addrdss);
    }

    public List<Order> getallorder() {
        List<Order> orderList = mineDAO.getallorder();
        return orderList;
    }

    public void chagst(int orid) {
        mineDAO.chag(orid);
    }
}
