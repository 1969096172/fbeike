package com.li.ers.dao;

import com.li.ers.model.Area;
import com.li.ers.model.House;
import com.li.ers.model.Housetype;

import java.util.List;

public interface IHouseDAO {
    List<House> gethouseList(String name, int ares, String zufangs, int housetype);

    House gethouse(int houseId);

    Area getarea(int areaId);

    Housetype gethousetype(int typeId);
}
