package com.li.ers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;

public class MineServlet extends HttpServlet {
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
//        HttpSession session = request.getSession();  //通过request获取session
//        int userid = (int) session.getAttribute("userid");
        System.out.println(fangId+"/");
        request.getRequestDispatcher("/WEB-INF/pages/appoint.jsp").forward(request, response);

    }
}
