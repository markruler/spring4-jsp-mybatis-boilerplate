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
<h1>Hello, World!</h1>
<a href="/users">User</a><br>
<a href="/files">File Management</a><br>
<a href="/unknown">Unknown Page</a><br>
<a href="/logoutProcess">Logout</a><br>

<div>
    <h1>include-react 빌드 후</h1>
    <a href="/a">A-B</a><br>
    <a href="/c">C-D</a><br>
</div>
</body>
</html>
