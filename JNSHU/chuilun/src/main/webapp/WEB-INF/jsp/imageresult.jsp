<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/05/06
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" >
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="loc" value="${loc}"/>
</json:object>

