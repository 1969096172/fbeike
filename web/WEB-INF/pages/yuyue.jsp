<%@ page import="com.li.ers.dao.impl.MineDAO" %>
<%@ page import="com.li.ers.model.House" %>
<%@ page import="com.li.ers.dao.impl.HouseDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/21
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .tou{
            float: left;
            width: 14%;
            border-left: 1px solid #B7BBC3;
            border-top: 1px solid #B7BBC3;
            border-bottom: 1px solid #B7BBC3;
            text-align: center;
            font-size: 13px;
            color: #B7BBC3;
        }
        #contion{
            height: 1px;
            clear: both;
            width: 100%;
            border-bottom: 1px solid #B7BBC3;
        }
        .con{
            float: left;
            width: 14%;
            text-align: center;
            font-size: 13px;
        }
        .fix{
             background-color: #B7BBC3;
             color: #dddddd;
             font-size: 14px;
             height: 20px;
             padding-left: 10px;
         }

    </style>
</head>
<body>
    <p style="font-size: 11px; color: #B7BBC3">如有问题请联系客服101079666</p>
    <p class="fix">预约</p>
    <p class="tou">预约时间</p>
    <p class="tou">预留电话</p>
    <p class="tou">用户</p>
    <p class="tou">房源</p>
    <p class="tou">租金（月）</p>
    <p class="tou">房源地址</p>
    <p class="tou">状态</p>
    <c:forEach items="${sessionScope['appointxx']}" var="appoint">
        <p class="con">${appoint.appointtime}</p>
        <p class="con">${appoint.appointtel}</p>
        <p class="con">${userxx.username}</p>
        <p class="con">${appoint.jieshao}</p>
        <p class="con">${appoint.rent}</p>
        <p class="con">${appoint.detailaddress}</p>
        <p class="con">
            <c:if test="${appoint.appointstate == 0}">未处理</c:if>
            <c:if test="${appoint.appointstate == 1}">已处理</c:if>
        </p>

        <div id="contion"></div>

    </c:forEach>

</body>
</html>
