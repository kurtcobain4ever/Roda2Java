<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/04/30
  Time: 01:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" >
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="id" value="${account.id}"/>
    <json:property name="username" value="${account.username}"/>
    <json:property name="nickname" value="${account.nickname}"/>
    <json:property name="role_id" value="${account.role_id}"/>
</json:object>
