package com.li.ers.servlet;

import com.li.ers.model.Area;
import com.li.ers.model.House;
import com.li.ers.model.Housetype;
import com.li.ers.service.HouseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeServlet extends HttpServlet {
    HouseService houseService = new HouseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");

        try{
            //利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            //执行相应的方法
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            // TODO AUTO-generated catch block
            e.printStackTrace();
        }
    }
    protected void gatfang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
//        介绍名
        String name = request.getParameter("ming");
//        地区
        String ares = request.getParameter("radio1");
        int areaid = 0;
        if (ares != null){
            areaid = Integer.parseInt(ares);
        }
//        租赁方式
        String zufangs = request.getParameter("zufangs");
        String housetypestr = request.getParameter("radio2");
        int housetype = 0;
        if (housetypestr != null){
            housetype = Integer.parseInt(housetypestr);
        }

        List<House> houseList = houseService.gethouselist(name, areaid, zufangs, housetype);
        HttpSession session = request.getSession();
        session.setAttribute("houseList", houseList);
        request.getRequestDispatcher("/WEB-INF/pages/zufang.jsp").forward(request, response);
    }


    protected void gofxiangqing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int houseId = Integer.parseInt(request.getParameter("houseId"));
        int areaId = Integer.parseInt(request.getParameter("areaId"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        House house = houseService.gethouse(houseId);
        Area area = houseService.getarea(areaId);
        Housetype housetype = houseService.gethousetype(typeId);

        HttpSession session = request.getSession();
        session.setAttribute("housexx", house);
        session.setAttribute("areaxx", area);
        session.setAttribute("housetypexx", housetype);
        request.getRequestDispatcher("/WEB-INF/pages/fxiangqing.jsp").forward(request, response);

    }
}
