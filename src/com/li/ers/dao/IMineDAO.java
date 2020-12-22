package com.li.ers.dao;

import com.li.ers.model.*;

import java.util.List;

public interface IMineDAO {
    void add(String tel, String time, int userid, int fangid);

    User getuser(int userid);

    List<Appoint> getappoint(int userid);

    void overop(int op, int i);

    void tofix(String oldpw, String newpw);

    void addorder(String data, String time, int userid, int fandido, double dqian);

    List<Order> getorder(int userid);

    List<Appoint> getadappint();

    List<User> getsusername(List<Appoint> appointList);

    List<Housetype> getkind();

    List<Area> getarea();

    void addfang(int areaidx, String xiaoqu, int kindidx, String chaoxiang, String dianti, String building, double expectation_price, String fangshi, String zuqi, String addrdss);

    List<Order> getallorder();

    void chag(int orid);
}
