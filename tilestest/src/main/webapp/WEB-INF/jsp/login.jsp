<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/05/24
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="${pageContext.request.contextPath}/loginx" method="post">
    <div class="input-form">
        <input type="text" name="username" placeholder="请输入账号">
    </div>
    <div class="input-form1">
        <input type="password" name="password" placeholder="请输入密码">
    </div>
    <div class="center">
        <input class="loginba" type="submit" value="登录">
    </div>
</form>
