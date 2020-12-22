package com.li.ers.dao;

import com.li.ers.model.Appoint;
import com.li.ers.model.Order;
import com.li.ers.model.User;

import java.util.List;

public interface IMineDAO {
    void add(String tel, String time, int userid, int fangid);

    User getuser(int userid);

    List<Appoint> getappoint(int userid);

    void overop(int op, int i);

    void tofix(String oldpw, String newpw);

    void addorder(String data, String time, int userid, int fandido, double dqian);

    List<Order> getorder(int userid);
}