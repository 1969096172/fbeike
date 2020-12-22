package com.li.ers.service;

import com.li.ers.dao.IMineDAO;
import com.li.ers.dao.impl.MineDAO;
import com.li.ers.model.Appoint;
import com.li.ers.model.Order;
import com.li.ers.model.User;

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
}
