package com.li.ers.dao.impl;

import com.li.ers.dao.IMineDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.*;

import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MineDAO implements IMineDAO {
    @Override
    public void add(String tel, String time, int userid, int fangid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String tody= df.format(new Date());// new Date()为获取当前系统时间
            String sql = "insert into appoint(appointdata, appointtime, appointtel, appointstate, userid, houseid) values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tody);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,tel);
            preparedStatement.setInt(4,0);
            preparedStatement.setInt(5,userid);
            preparedStatement.setInt(6,fangid);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DBershou.release(connection);
        }
    }

    @Override
    public User getuser(int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from user where userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setUserid(resultSet.getInt("userid"));
                user.setUseraccount(resultSet.getString("useraccount"));
                user.setUserpassword(resultSet.getString("userpassword"));
                user.setUsername(resultSet.getString("username"));
                user.setUsertel(resultSet.getString("usertel"));
                user.setUsermoney(resultSet.getDouble("usermoney"));
                user.setUsercard(resultSet.getString("usercard"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public List<Appoint> getappoint(int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from appoint where userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            List<Appoint> appointList = new ArrayList<>();
            while (resultSet.next()){
                Appoint appoint = new Appoint();
                appoint.setUserid(resultSet.getInt("userid"));
                appoint.setAppointid(resultSet.getInt("appointid"));
                appoint.setAppointdata(resultSet.getString("appointdata"));
                appoint.setAppointtime(resultSet.getString("appointtime"));
                appoint.setAppointtel(resultSet.getString("appointtel"));
                appoint.setAppointstate(resultSet.getInt("appointstate"));
                appoint.setHouseid(resultSet.getInt("houseid"));
                HouseDAO houseDAO  = new HouseDAO();
                House house = houseDAO.gethouse(resultSet.getInt("houseid"));
                appoint.setJieshao(house.getJieshao());
                appoint.setRent(house.getRent());
                appoint.setDetailaddress(house.getDetailaddress());
                appointList.add(appoint);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return appointList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public void overop(int op, int i) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "update appoint set appointstate=? where appointid=?";
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,i);
            preparedStatement.setInt(2,op);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }

    }

    @Override
    public void tofix(String oldpw, String newpw) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "update user set userpassword=? where userpassword=?";
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newpw);
            preparedStatement.setString(2,oldpw);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }

    @Override
    public void addorder(String data, String time, int userid, int fandido, double dqian) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String tody= df.format(new Date());// new Date()为获取当前系统时间
            String sql = "insert into orders(ordertime, starttime, endtime, money, userid, houseid, orderst) values(?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tody);
            preparedStatement.setString(2,data);
            preparedStatement.setString(3,time);
            preparedStatement.setDouble(4,dqian);
            preparedStatement.setInt(5,userid);
            preparedStatement.setInt(6,fandido);
            preparedStatement.setInt(7,0);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DBershou.release(connection);
        }
    }

    @Override
    public List<Order> getorder(int userid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from orders where userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userid);
            resultSet = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderid(resultSet.getInt("ordersid"));
                order.setOrdertime(resultSet.getString("ordertime"));
                order.setStarttime(resultSet.getString("starttime"));
                order.setEndtime(resultSet.getString("endtime"));
                order.setMoney(resultSet.getDouble("money"));
                order.setUserid(resultSet.getInt("userid"));
                order.setHouseid(resultSet.getInt("houseid"));
                order.setOrderst(resultSet.getInt("orderst"));
                HouseDAO houseDAO  = new HouseDAO();
                House house = houseDAO.gethouse(resultSet.getInt("houseid"));
                order.setJieshao(house.getJieshao());
                order.setRent(house.getRent());
                order.setDetailaddress(house.getDetailaddress());
                orderList.add(order);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public List<Appoint> getadappint() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from appoint";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Appoint> appointList = new ArrayList<>();
            while (resultSet.next()){
                Appoint appoint = new Appoint();
                appoint.setUserid(resultSet.getInt("userid"));
                appoint.setAppointid(resultSet.getInt("appointid"));
                appoint.setAppointdata(resultSet.getString("appointdata"));
                appoint.setAppointtime(resultSet.getString("appointtime"));
                appoint.setAppointtel(resultSet.getString("appointtel"));
                appoint.setAppointstate(resultSet.getInt("appointstate"));
                appoint.setHouseid(resultSet.getInt("houseid"));
                appointList.add(appoint);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return appointList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public List<User> getsusername(List<Appoint> appointList) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            List<User> userList = new ArrayList<>();
            connection = DBershou.getConnection();
            for (Appoint appoint : appointList) {
                String sql = "select * from user where userid=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,appoint.getUserid());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    User user = new User();
                    user.setUsername(resultSet.getString("username"));
                    userList.add(user);
                }
                resultSet.close();
                preparedStatement.close();
            }
            connection.close();
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }

        return null;
    }

    @Override
    public List<Housetype> getkind() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from housetype";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Housetype> housetypeList = new ArrayList<>();
            while (resultSet.next()){
                Housetype housetype = new Housetype();
                housetype.setTypeid(resultSet.getInt("typeid"));
                housetype.setTypename(resultSet.getString("typename"));
                housetypeList.add(housetype);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return housetypeList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public List<Area> getarea() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from area";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Area> areaList = new ArrayList<>();
            while (resultSet.next()){
                Area area = new Area();
                area.setAreaid(resultSet.getInt("areaid"));
                area.setAreaname(resultSet.getString("areaname"));
                areaList.add(area);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return areaList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public void addfang(int areaidx, String xiaoqu, int kindidx, String chaoxiang, String dianti, String building, double expectation_price, String fangshi, String zuqi, String addrdss) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "insert into house(jieshao, fangshi, rent, direction, period, detailaddress, status, floor, elevator, admind, typeid, areaid) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,xiaoqu);
            preparedStatement.setString(2,fangshi);
            preparedStatement.setDouble(3,expectation_price);
            preparedStatement.setString(4,chaoxiang);
            preparedStatement.setString(5,zuqi);
            preparedStatement.setString(6,addrdss);
            preparedStatement.setInt(7,0);
            preparedStatement.setString(8,building);
            preparedStatement.setString(9,dianti);
            preparedStatement.setInt(10,1);
            preparedStatement.setInt(11,kindidx);
            preparedStatement.setInt(12,areaidx);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DBershou.release(connection);
        }
    }

    @Override
    public List<Order> getallorder() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from orders where orderst=0";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Order> orderList = new ArrayList<>();
            while (resultSet.next()){
                Order order = new Order();
                order.setOrderid(resultSet.getInt("ordersid"));
                order.setOrdertime(resultSet.getString("ordertime"));
                order.setStarttime(resultSet.getString("starttime"));
                order.setEndtime(resultSet.getString("endtime"));
                order.setMoney(resultSet.getDouble("money"));
                order.setUserid(resultSet.getInt("userid"));
                order.setHouseid(resultSet.getInt("houseid"));
                order.setOrderst(resultSet.getInt("orderst"));
                orderList.add(order);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public void chag(int orid) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "update orders set orderst=1 where ordersid=?";
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,orid);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
    }
}
