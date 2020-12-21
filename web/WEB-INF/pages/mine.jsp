<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/12/21
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%
    String jsUrl=request.getContextPath()+"/public/js/";
    String cssUrl=request.getContextPath()+"/public/css/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>贝壳-F</title>
    <link href="<%=cssUrl%>mine.css" rel="stylesheet">
    <link rel="alternate" media="only screen and (max-width:640px)" href="https://m.ke.com/chuzu/cd/zufang/CD2219512414620360704.html">
    <!-- 是否需要加载common.css -->
    <link rel="stylesheet" href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/common/css/common.css?_v=20201214143047025">
    <!-- 载入灯塔 -->
    <!-- 接入灯塔 -->
    <link rel="stylesheet" href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/page/detail/index.css?_v=20201214143047025">
    <!-- 载入后台返回的css文件 -->
    <link rel="stylesheet" href="https://s1.ljcdn.com/matrix_pc/dist/pc/src/module/send_message/index.css?_v=20201214143047025">

</head>
<body>
<%@ include file="/commons/head.jsp"%>

<div id="bod">
    <div class="con-left">
        <img id="touimg" src="${pageContext.request.contextPath}/public/img/mine.png" >
        <div class="toutext">欢迎您:</div>
        <ul>
            <li class="ifrli">
                <a target="minenav">预约信息</a>
            </li>
            <li class="ifrli">
                <a target="minenav">签订合同</a>
            </li>
            <li class="ifrli">
                <a target="minenav">编辑资料</a>
            </li>
        </ul>
    </div>
    <div class="con-right">
        <iframe src="" name="minenav" frameborder="0"width="100%" height="100%" scrolling="yes"></iframe>
    </div>
</div>
<%@ include file="/commons/footer.jsp"%>
</body>
</html>
