package com.li.ers.servlet;

import com.li.ers.model.User;
import com.li.ers.service.LoginService;
import com.li.ers.service.MineService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();
    MineService mineService = new MineService();
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

    /**
     * 进入登录页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

    }
    protected void login_in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String useraccount = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        if (useraccount.equals("admin")){
//            int adminid = loginService.admin_in(useraccount,userpassword);
//            List<Goods> goodsList =  adminService.getad0goods();
//            HttpSession session = request.getSession();  //通过request获取session
//            session.setAttribute("adminid",adminid);
//            session.setAttribute("goodsList",goodsList);
//            request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);
        }else {
            int userid = loginService.login_in(useraccount,userpassword);
            HttpSession session = request.getSession();  //通过request获取session
            session.setAttribute("userid",userid);
            response.sendRedirect("index.jsp");
        }

    }
    protected void login_up(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useraccount = request.getParameter("useraccount");
        String userpassword = request.getParameter("userpassword");
        String username = request.getParameter("username");
        String usertel = request.getParameter("usertel");
        String usercardid = request.getParameter("usercardid");

        loginService.adduser(useraccount, userpassword, username, usertel, usercardid);


        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

    }
    protected void getmine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();  //通过request获取session
        int userid = (int) session.getAttribute("userid");
        User userxx = mineService.getuser(userid);
        session.setAttribute("userxx", userxx);
        request.getRequestDispatcher("/WEB-INF/pages/mine.jsp").forward(request, response);

    }

    protected void admin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/admin/admin.jsp").forward(request, response);

    }
}
