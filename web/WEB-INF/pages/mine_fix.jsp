<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/22
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .fix{
            background-color: #B7BBC3;
            color: #dddddd;
            font-size: 14px;
            height: 20px;
            padding-left: 10px;
        }
        .rtd{
            font-size: 15px;
            color: #B7BBC3;
        }
    </style>
</head>
<body style="padding-left: 10px">
<h2>我的账号信息</h2>
<p style="font-size: 11px; color: #B7BBC3">如要注销账号请联系客服101079666</p>
<p class="fix">修改密码</p>
<div>
    <form action="${pageContext.request.contextPath }/mineServlet?method=tofix" method="post">
        <table style="margin: 30px auto">
            <tr>
                <td class="rtd">输入旧密码：</td>
                <td><input type="password" value="" name="oldpw"></td>
            </tr>
            <tr>
                <td class="rtd">输入新密码</td>
                <td><input type="password" value="" name="newpw"></td>
            </tr>
            <tr>
                <td></td>
                <td ><button type="submit" style="background-color: #E6E5E5; color: #B7BBC3; border: none; padding: 3px 5px">确认</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
