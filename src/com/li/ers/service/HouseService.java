package com.li.ers.service;

import com.li.ers.dao.IHouseDAO;
import com.li.ers.dao.impl.HouseDAO;
import com.li.ers.model.Area;
import com.li.ers.model.House;
import com.li.ers.model.Housetype;

import java.util.List;

public class HouseService {
    IHouseDAO houseDAO = new HouseDAO();

    public List<House> gethouselist(String name, int ares, String zufangs, int housetype) {
        List<House> houseList = houseDAO.gethouseList(name, ares, zufangs, housetype);
        return houseList;
    }

    public House gethouse(int houseId) {
        House house  = houseDAO.gethouse(houseId);
        return house;
    }

    public Area getarea(int areaId) {
        Area area  = houseDAO.getarea(areaId);
        return area;
    }

    public Housetype gethousetype(int typeId) {
        Housetype housetype  = houseDAO.gethousetype(typeId);
        return housetype;
    }
}
