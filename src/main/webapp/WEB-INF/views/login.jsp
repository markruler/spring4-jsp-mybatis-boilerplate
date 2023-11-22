<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Login page</title>
</head>
<body>
Login
<br>
<form action="/loginProcess" method="post">
    <input
            type="text"
            name="uesrname"
            maxlength="20"
            placeholder="Type mark"/>
    <input
            type="password"
            name="password"
            maxlength="20"
            placeholder="Type pass"/>
    <button type="submit">Sign in</button>
</form>
</body>
</html>
