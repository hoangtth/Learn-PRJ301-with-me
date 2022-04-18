<%-- 
    Document   : create
    Created on : Apr 15, 2022, 9:42:24 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="create" method="POST">
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" value="" /></td>
                </tr>
                <tr>
                    <td>Mark: </td>
                    <td><input type="text" name="mark" value="" /></td>
                </tr>
                <tr>
                    <td>
                        ClassName:   
                    </td>
                    <td>
                        <select name="classId">
                            <c:forEach items="${listClasses}" var="C">
                                <option value="${C.classId}">${C.className}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Create">
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
