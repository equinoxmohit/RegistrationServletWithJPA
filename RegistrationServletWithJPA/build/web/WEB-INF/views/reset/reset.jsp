<%-- 
    Document   : reset
    Created on : Sep 8, 2016, 7:45:51 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <div>
            <form method="post" action=""  style="font-family: sans-serif">
                <div>
                    <label>Password:</label>
                    <input type="password" name="pass1" id="pass1"  required="required" style="width: 100%">
                </div>
                <br>
                <div>
                    <label>Confirm Password:</label>
                    <input type="password" name="pass2" id="pass2" onkeyup="checkPass();
                                return false;"  required="required" style="width: 100%">
                    <span id="confirmMessage" class="confirmMessage"></span>
                </div>
                <div>
                    <br>
                    <button>Change Password</button>
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
