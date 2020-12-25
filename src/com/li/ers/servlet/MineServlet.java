package com.li.ers.servlet;

import com.li.ers.model.Appoint;
import com.li.ers.model.House;
import com.li.ers.model.Order;
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
        String time = new String(request.getParameter("time").getBytes("ISO-8859-1"),"utf-8");
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

    protected void seorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();  //通过request获取session
        int userid = (int) session.getAttribute("userid");
        User userxx = mineService.getuser(userid);

        List<Order> orderList = mineService.getorder(userid);
        session.setAttribute("orderxx", orderList);
        session.setAttribute("userxx", userxx);
        request.getRequestDispatcher("/WEB-INF/pages/seorder.jsp").forward(request, response);

    }

    protected void goorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fangId = request.getParameter("fangid");
        int fid = Integer.parseInt(fangId);
        House house = houseService.gethouse(fid);
        HttpSession session = request.getSession();  //通过request获取session
        if (session.getAttribute("userid") != null){
            session.setAttribute("fandidop", fangId);
            session.setAttribute("fg", house);
            request.getRequestDispatcher("/WEB-INF/pages/order.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
    protected void toorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = new String(request.getParameter("data").getBytes("ISO-8859-1"),"utf-8");
        String time = request.getParameter("time");
        String qian = request.getParameter("qian");
        double dqian = Double.parseDouble(qian);
        int fandido = Integer.parseInt(request.getParameter("fangide"));
        HttpSession session = request.getSession();  //通过request获取session
        int userid = (int) session.getAttribute("userid");

        mineService.addorder(data, time, dqian, userid, fandido);
        houseService.chagst(fandido);
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
    protected void adappint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Appoint> appointList = mineService.getadappoint();
        List<User> userList = mineService.gerusername(appointList);
        HttpSession session = request.getSession();  //通过request获取session
        session.setAttribute("adappointList", appointList);
        session.setAttribute("useradxx", userList);
        request.getRequestDispatcher("/WEB-INF/admin/adappint.jsp").forward(request, response);

    }

    protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/admin/upload.jsp").forward(request, response);

    }
    protected void upfang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int areaidx = Integer.parseInt(request.getParameter("areaidx"));
        String xiaoqu = request.getParameter("xiaoqu");
        int kindidx = Integer.parseInt(request.getParameter("kindidx"));
        String chaoxiang = request.getParameter("chaoxiang");
        String dianti = request.getParameter("dianti");
        String building = request.getParameter("building");
        double expectation_price = Double.parseDouble(request.getParameter("expectation_price"));
        String fangshi = request.getParameter("fangshi");
        String zuqi = request.getParameter("zuqi");
        String addrdss = request.getParameter("addrdss");

        mineService.addfang(areaidx, xiaoqu, kindidx, chaoxiang, dianti, building, expectation_price, fangshi, zuqi, addrdss);

        request.getRequestDispatcher("/WEB-INF/admin/upload.jsp").forward(request, response);

    }

    protected void adorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();  //通过request获取session

        List<Order> adorderList = mineService.getallorder();
        session.setAttribute("adorderxx", adorderList);
        request.getRequestDispatcher("/WEB-INF/admin/adorder.jsp").forward(request, response);

    }
    protected void chagorst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orid = Integer.parseInt(request.getParameter("adorderid"));
        mineService.chagst(orid);
        adorder(request,response);
    }
}
