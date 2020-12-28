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
            width: 19%;
            border-left: 1px solid #0075FF;
            border-top: 1px solid #0075FF;
            border-bottom: 1px solid #0075FF;
            text-align: center;
        }
        .tou:nth-child(1){
            border-left: none;
        }
        #contion{
            height: 1px;
            clear: both;
            width: 100%;
            border-bottom: 1px solid #B7BBC3;
        }
        .con{
            float: left;
            width: 19%;
            text-align: center;
            font-size: 13px;
        }

    </style>
</head>
<body>
<p class="tou">预约时间</p>
<p class="tou">预留电话</p>
<p class="tou">用户</p>
<p class="tou">房源编号</p>
<p class="tou">操作</p>

<c:forEach items="${sessionScope['adappointList']}" var="appoint">

    <p class="con">${appoint.appointtime}</p>
    <p class="con">${appoint.appointtel}</p>
    <p class="con">${appoint.userid}</p>
    <p class="con">${appoint.houseid}</p>
    <p class="con">
        <c:if test="${appoint.appointstate == 1}">已完成</c:if>
        <c:if test="${appoint.appointstate == 0}"><a href="${pageContext.request.contextPath}/mineServlet?method=voeryuyue&opid=${appoint.appointid}">完成预约</a></c:if>
    </p>

    <div id="contion"></div>
</c:forEach>

</body>
</html>
