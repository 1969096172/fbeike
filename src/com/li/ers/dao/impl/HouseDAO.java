package com.li.ers.dao.impl;

import com.li.ers.dao.IHouseDAO;
import com.li.ers.db.DBershou;
import com.li.ers.model.Area;
import com.li.ers.model.House;
import com.li.ers.model.Housetype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HouseDAO implements IHouseDAO {

    @Override
    public List<House> gethouseList(String name, int ares, String zufangs, int housetype) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{

            String sql = "select * from house where status=0";
            connection = DBershou.getConnection();
            if(ares > 0){
                sql += " and areaid="+ares;
            }
            if(housetype > 0){
                sql += " and typeid="+housetype;
            }
            if("合租".equals(zufangs) || "整租".equals(zufangs)){
                sql += " and fangshi='"+zufangs+"'";
            }
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            List<House> houseList = new ArrayList<>();
            while (resultSet.next()){
                House house = new House();
                house.setHouseid(resultSet.getInt("houseid"));
                house.setJieshao(resultSet.getString("jieshao"));
                house.setFangshi(resultSet.getString("fangshi"));
                house.setRent(resultSet.getDouble("rent"));
                house.setDirection(resultSet.getString("direction"));
                house.setPeriod(resultSet.getString("period"));
                house.setDetailaddress(resultSet.getString("detailaddress"));
                house.setStatus(resultSet.getInt("status"));
                house.setFloor(resultSet.getString("floor"));
                house.setElevator(resultSet.getString("elevator"));
                house.setAdmind(resultSet.getInt("admind"));
                house.setTypeid(resultSet.getInt("typeid"));
                house.setAreaid(resultSet.getInt("areaid"));
                house.setImgone(resultSet.getString("imgone"));
                house.setImgtwo(resultSet.getString("imgtwo"));
                house.setImgthree(resultSet.getString("imgthree"));
                houseList.add(house);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return houseList;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }
        return null;
    }

    @Override
    public House gethouse(int houseId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from house where houseid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,houseId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                House house = new House();
                house.setHouseid(resultSet.getInt("houseid"));
                house.setJieshao(resultSet.getString("jieshao"));
                house.setFangshi(resultSet.getString("fangshi"));
                house.setRent(resultSet.getDouble("rent"));
                house.setDirection(resultSet.getString("direction"));
                house.setPeriod(resultSet.getString("period"));
                house.setDetailaddress(resultSet.getString("detailaddress"));
                house.setStatus(resultSet.getInt("status"));
                house.setFloor(resultSet.getString("floor"));
                house.setElevator(resultSet.getString("elevator"));
                house.setAdmind(resultSet.getInt("admind"));
                house.setTypeid(resultSet.getInt("typeid"));
                house.setAreaid(resultSet.getInt("areaid"));
                house.setImgone(resultSet.getString("imgone"));
                house.setImgtwo(resultSet.getString("imgtwo"));
                house.setImgthree(resultSet.getString("imgthree"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return house;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }

        return null;
    }

    @Override
    public Area getarea(int areaId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from area where areaid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,areaId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Area area = new Area();
                area.setAreaid(resultSet.getInt("areaid"));
                area.setAreaname(resultSet.getString("areaname"));

                resultSet.close();
                preparedStatement.close();
                connection.close();
                return area;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }

        return null;
    }

    @Override
    public Housetype gethousetype(int typeId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DBershou.getConnection();
            String sql = "select * from housetype where typeid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,typeId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Housetype housetype = new Housetype();
                housetype.setTypeid(resultSet.getInt("typeid"));
                housetype.setTypename(resultSet.getString("typename"));

                resultSet.close();
                preparedStatement.close();
                connection.close();
                return housetype;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBershou.release(connection);
        }

        return null;
    }

    @Override
    public void chagest(int fandido) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "update house set status=1 where houseid=?";
            connection = DBershou.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,fandido);

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
