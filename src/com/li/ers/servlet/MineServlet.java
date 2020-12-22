package com.li.ers.servlet;

import com.li.ers.model.Appoint;
import com.li.ers.model.User;
import com.li.ers.service.HouseService;
import com.li.ers.service.MineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MineServlet extends HttpServlet {
    MineService mineService = new MineService();
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

    protected void goappoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fangId = request.getParameter("fangid");
        System.out.println(fangId);
        HttpSession session = request.getSession();  //通过request获取session
        if (session.getAttribute("userid") != null){
            session.setAttribute("fandidop", fangId);
            request.getRequestDispatcher("/WEB-INF/pages/appoint.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    protected void toappoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tel = request.getParameter("tel");
        String time = request.getParameter("time");
        int fandido = Integer.parseInt(request.getParameter("fangide"));
        HttpSession session = request.getSession();  //通过request获取session
        int userid = (int) session.getAttribute("userid");

        mineService.add(tel, time, userid, fandido);
        houseService.chagst(fandido);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void goyuyue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();  //通过request获取session
        int userid = (int) session.getAttribute("userid");
        User userxx = mineService.getuser(userid);

        List<Appoint> appointList = mineService.getappoint(userid);
        session.setAttribute("appointxx", appointList);
        session.setAttribute("userxx", userxx);
        request.getRequestDispatcher("/WEB-INF/pages/yuyue.jsp").forward(request, response);

    }
    protected void voeryuyue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int op = Integer.parseInt(request.getParameter("opid"));
       mineService.overap(op,1);
       goyuyue(request,response);
    }

    protected void gofix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/mine_fix.jsp").forward(request, response);

    }

    protected void tofix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpw = request.getParameter("oldpw");
        String newpw = request.getParameter("newpw");
        mineService.tofix(oldpw, newpw);
        request.getRequestDispatcher("/WEB-INF/pages/mine_fix.jsp").forward(request, response);

    }
}
