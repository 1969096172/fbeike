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
            width: 12.2%;
            border-left: 1px solid #B7BBC3;
            border-top: 1px solid #B7BBC3;
            border-bottom: 1px solid #B7BBC3;
            text-align: center;
            font-size: 13px;
            color: #B7BBC3;
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
            width: 12.2%;
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
<p class="fix">合同列表</p>
<p class="tou">入住时间</p>
<p class="tou">租期(月)</p>
<p class="tou">金额(¥)</p>
<p class="tou">用户</p>
<p class="tou">房源</p>
<p class="tou">租金（月）</p>
<p class="tou">房源地址</p>
<p class="tou">状态</p>
<c:forEach items="${sessionScope['orderxx']}" var="orderxx">
    <p class="con">${orderxx.starttime}</p>
    <p class="con">${orderxx.endtime}</p>
    <p class="con">${orderxx.money}</p>
    <p class="con">${userxx.username}</p>
    <p class="con">${orderxx.jieshao}</p>
    <p class="con">${orderxx.rent}</p>
    <p class="con">${orderxx.detailaddress}</p>
    <p class="con">
        <c:if test="${orderxx.orderst == 0}">生效中</c:if>
        <c:if test="${orderxx.orderst == 1}">已失效</c:if>
    </p>
    <div id="contion"></div>

</c:forEach>

</body>
</html>
