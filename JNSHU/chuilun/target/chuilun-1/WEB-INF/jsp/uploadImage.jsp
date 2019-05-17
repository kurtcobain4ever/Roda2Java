<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/04/20
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
</head>
<body>
<form action="/a/image" method="post" enctype="multipart/form-data">
    上传图片：<input type="file" name="img"/><br>
    <input type="submit" value="提交图片">
</form>
</body>
</html>
