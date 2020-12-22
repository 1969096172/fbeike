package com.li.ers.service;

import com.li.ers.dao.IMineDAO;
import com.li.ers.dao.impl.MineDAO;
import com.li.ers.model.Appoint;
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
}
