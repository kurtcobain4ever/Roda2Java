<%--
  Created by IntelliJ IDEA.
  User: ALIENWARE
  Date: 2019/04/19
  Time: 22:25
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
    <json:array name="data" var="item" items="${works}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="works_name" value="${item.works_name}"/>
            <json:property name="loc" value="${item.loc}"/>
        </json:object>
    </json:array>
</json:object>