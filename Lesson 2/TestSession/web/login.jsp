<%-- 
    Document   : login
    Created on : Apr 19, 2022, 3:04:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
        Username: <input type="text" name="user" /><br/>
        Password: <input type="password" name="pass" /><br/>
        <input type="submit" value="login"/>
        </form>
    </body>
</html>
