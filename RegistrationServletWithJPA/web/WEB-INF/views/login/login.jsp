<%-- 
    Document   : login
    Created on : Sep 8, 2016, 6:44:30 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="font-family: sans-serif">
        <h1>Login</h1>
        <form action="" method="post">
            <div>
                <label>Username</label>
                <input type="text" required="required" placeholder="enter your username..." style="width: 100%" name="username"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" required="required" placeholder="enter your password..." style="width: 100%" name="password"/>
            </div>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Clear</button>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/forgot">Forgot Password</a>
            </div>
        </form>
    </body>
</html>
