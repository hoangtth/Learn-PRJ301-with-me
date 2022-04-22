<%-- 
    Document   : login
    Created on : Apr 22, 2022, 9:01:55 PM
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
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="user" value="" /></td>
                </tr>
                <tr>
                    <td>password:</td>
                    <td><input type="password" name="pass" value="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"  value="Login" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
