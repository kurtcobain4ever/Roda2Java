    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
        <%@ page import="com.fan.demo.util.DESUtil" %>
        <%@ page import="com.fan.demo.util.JWTUtil" %>
        <%--
          Created by IntelliJ IDEA.
          User: ALIENWARE
          Date: 2019/05/21
          Time: 11:34
          To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
<div class="top container">
        <%! boolean result = false;
            String value = null;
        %>
        <%
            Cookie[] cookies = request.getCookies();
            for (int i=0; i<cookies.length;i++){
                if(cookies[i].getName().equals("token")){
                  String token= DESUtil.desDecript(cookies[i].getValue());
                  value=JWTUtil.toolNickname(token);
                    result=true;
                    break;
                }else {
                    result=false;
                }
            }
        %>
        <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
        <div>
        <c:choose>
            <c:when test="<%=result%>">
                <i style="color: #000000; font-size: x-small"><%=value%>欢迎您! </i>
                <a class="btn btn-sm" href="${pageContext.request.contextPath}/logout" style="color: #2e6da4">注销</a>
            </c:when>
            <c:otherwise>
                <a class="btn btn-sm" href="${pageContext.request.contextPath}/login" style="color: #2e6da4">登录</a>
                <a class="btn btn-sm" href="${pageContext.request.contextPath}/register" style="color: #2e6da4">注册</a>
            </c:otherwise>
        </c:choose>
        <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/images/54537.png"></a>
        <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath}/static/images/45678678.png"></a>
        <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/images/54375483543.png"></a>
        </div>
        </div>
        </div>


</div>
<div style="width: 100%" role="navigation" class="nav1 navbar navbar-default">
    <div class="container">
        <div class="header-logo">
            <div class="logo-middle"><img src="${pageContext.request.contextPath}/static//images/logo.png"></div>
        </div>
        <div class="navbar-header marginTop">
            <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div id="example-navbar-collapse" class=" collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <a href="${pageContext.request.contextPath}/home"><li>首 页</li></a>
                <a href="${pageContext.request.contextPath}/u/profession"><li>职 业</li></a>
                <a href=""><li>关 于</li></a>
            </ul>
        </div>
    </div>
</div>
</header>
