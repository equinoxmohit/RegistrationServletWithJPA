<%-- 
    Document   : index
    Created on : Sep 8, 2016, 6:21:49 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="font-family:cursive">
        <h1>Welcome to Registration Management System</h1>
        <h3>You can either register, or login</h3>
        <a href="${pageContext.request.contextPath}/register">Register</a>
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </body>
</html>
