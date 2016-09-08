<%-- 
    Document   : register
    Created on : Sep 8, 2016, 6:43:46 PM
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
        <h1>Registration Form:</h1>
        <div>
            <form method="post" action="">
                <div>
                    <label>First Name:</label>
                    <input type="text" placeholder="enter first name..." name="firstName" required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Last Name:</label>
                    <input type="text" placeholder="enter last name..." name="lastName" required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Username:</label>
                    <input type="text" placeholder="enter username..." name="username" required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Email:</label>
                    <input type="email" placeholder="enter email..." name="email" required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Password:</label>
                    <input type="password" placeholder="enter password..." name="pass1" id="pass1"  required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Confirm Password:</label>
                    <input type="password" name="pass2" id="pass2" onkeyup="checkPass();
                            return false;" placeholder="re-enter password..."  required="required" style="width: 100%">
                    <span id="confirmMessage" class="confirmMessage"></span>
                </div>
                <div>
                    <br>
                    <button >Register</button>
                    <a href="${pageContext.request.contextPath}/login">Login</a>
                </div>

            </form>
        </div>


        <script>
            function checkPass()
            {
                var pass1 = document.getElementById('pass1');
                var pass2 = document.getElementById('pass2');
                var message = document.getElementById('confirmMessage');
                var goodColor = "#66cc66";
                var badColor = "#ff6666";
                if (pass1.value == pass2.value) {
                    pass2.style.backgroundColor = goodColor;
                    message.style.color = goodColor;
                    message.innerHTML = "Passwords Match!"
                } else {
                    pass2.style.backgroundColor = badColor;
                    message.style.color = badColor;
                    message.innerHTML = "Passwords Do Not Match!"
                }
            }
            ;

        </script>  
    </body>
</html>
