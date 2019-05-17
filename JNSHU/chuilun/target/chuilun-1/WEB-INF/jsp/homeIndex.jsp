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
    <json:array name="setdata" var="item" items="${setTitles}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
            <json:property name="level" value="${item.level}"/>
            <json:property name="status" value="${item.status}"/>
            <json:property name="editor_id" value="${item.editor_id}"/>
            <json:property name="editor" >
                <c:out value="${accountMap[item.editor_id]}"/>
            </json:property>
            <json:property name="create_at" value="${item.create_at}"/>
            <json:property name="update_at" value="${item.update_at}"/>
            <json:array name="themedata" var="secitem" items="${item.cTitles}">
                <json:object >
                    <json:property name="id" value="${secitem.id}"/>
                    <json:property name="name" value="${secitem.name}"/>
                    <json:property name="level" value="${secitem.level}"/>
                    <json:property name="status" value="${secitem.status}"/>
                    <json:property name="editor_id" value="${secitem.editor_id}"/>
                    <json:property name="editor" >
                        <c:out value="${accountMap[secitem.editor_id]}"/>
                    </json:property>
                    <json:property name="create_at" value="${secitem.create_at}"/>
                    <json:property name="update_at" value="${secitem.update_at}"/>
                </json:object>
            </json:array>
        </json:object>
    </json:array>
</json:object>