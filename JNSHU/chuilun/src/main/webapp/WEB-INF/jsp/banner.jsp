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
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" >
        <spring:message code="${code}"/>
    </json:property>
    <json:array name="data" var="item" items="${banners}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
            <json:property name="url" value="${item.url}"/>
            <json:property name="loc" value="${item.loc}"/>
            <json:property name="editor_id" value="${item.editor_id}"/>
            <json:property name="index" value="${item.ind}"/>
            <json:property name="create_at" value="${item.create_at}"/>
            <json:property name="update_at" value="${item.update_at}"/>
        </json:object>
    </json:array>
</json:object>