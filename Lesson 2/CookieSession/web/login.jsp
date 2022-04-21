<%-- 
    Document   : login
    Created on : Apr 18, 2022, 9:34:59 PM
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
                    <td>Username: </td>
                    <td><input type="text" name="user" value="" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="pass" value="" /></td>
                </tr>
                <tr>
                    <td>remember me </td>
                    <td><input type="checkbox" name="remember" value="true" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                    <td></td>
                </tr>
                <h3 style="color: red">${err}</h3>
            </table>
        </form>
    </body>
</html>
