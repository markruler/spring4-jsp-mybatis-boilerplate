<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <title>Welcome com.markruler.legacy.micro.page</title>
    <link rel="stylesheet" type="text/css" href="resources/css/index.css"/>
</head>
<body>
Hello, World!<br>
<div>
    <sec:authorize access="isAuthenticated()">
        <%--<jsp:include com.markruler.legacy.micro.page="/WEB-INF/views/welcome.jsp"/> <sec:authentication property="name"/>--%>
        <jsp:include page="/externalFileServlet"/> <sec:authentication property="name"/>
    </sec:authorize>
</div>
<a href="/users">User</a><br>
<a href="/files">File Management</a><br>
<a href="/unknown">Unknown Page</a><br>
<a href="/logoutProcess">Logout</a>
</body>
</html>
