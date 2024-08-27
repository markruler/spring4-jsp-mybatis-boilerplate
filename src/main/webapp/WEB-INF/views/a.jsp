<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <sec:authorize access="isAuthenticated()">
            <%--<jsp:include com.markruler.legacy.micro.page="/WEB-INF/views/welcome.jsp"/> <sec:authentication property="name"/>--%>
            <jsp:include page="/externalFileServlet"/>
            <sec:authentication property="name"/>
        </sec:authorize>
    </div>
</body>
</html>
