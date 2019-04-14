<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/03/30
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<% String path=request.getContextPath();--%>
<%--<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"--%>
<%--%>--%>


<%--<html>--%>
<%--<head>--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF8">--%>
    <%--<title>StudentList</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>学生列表</h1>--%>
<%--<table border="2">--%>
<%--<tr>--%>
    <%--<td>学生ID</td>--%>
    <%--<td>学生姓名</td>--%>
    <%--<td>学生年龄</td>--%>
<%--</tr>--%>
<%--<c:forEach items="${users}" var="item">--%>
    <%--<tr>--%>
        <%--<td>${item.id}</td>--%>
        <%--<td>${item.name}</td>--%>
        <%--<td>${item.age}</td>--%>
        <%--<td>--%>
            <%--<button onclick="window.location.href='/a/student/${item.id}'">删除</button>--%>
        <%--</td>--%>
        <%--<td>--%>
            <%--<button onclick="window.location.href='/a/studentput/${item.id}'">更新</button>--%>
        <%--</td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
    <%--<tr>--%>
        <%--<button onclick="window.location.href='/a/studentadd'">增加</button>--%>
    <%--</tr>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>

<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" >
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data" var="item" items="${users}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
            <json:property name="age" value="${item.age}"/>
        </json:object>
    </json:array>
</json:object>
