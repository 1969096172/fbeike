package com.li.ers.dao.impl;

import com.li.ers.dao.IMineDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Appoint;
import com.li.ers.model.User;

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
            String sql = "select * from appoint where userid=? and appointstate=0";
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
}
