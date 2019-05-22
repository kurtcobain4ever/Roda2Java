<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link href="<c:url value='/static/t10/bootstrap.min.css' />"  rel="stylesheet"/>
    <link href="<c:url value='/static/t10/dfghrgdffbdfb6base.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/t10/ghjghjghjbnmyhj.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/t10/Untitled-1base.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/t10/Untitled-3.css'/>" rel="stylesheet"/>
    <%--profession--%>
    <link href="<c:url value='/static/t11/base.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/t11/font.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/t11/t11.css'/>" rel="stylesheet"/>
    <script src="<c:url value='/static/t10/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/t10/bootstrap.min.js'/>"></script>
    </head>
<body class="sticky-header">
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header>
    <main>
        <tiles:insertAttribute name="main" />
    </main>
    <footer>
        <tiles:insertAttribute name="footer" />
    </footer>
</body>
</html>