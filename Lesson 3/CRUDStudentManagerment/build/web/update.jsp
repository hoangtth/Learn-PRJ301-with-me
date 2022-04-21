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
        <form action="update-student" method="POST">
            <table>
                    <td><input type="hidden" name="id" value="${student.id}" /></td>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" value="${student.name}" /></td>
                </tr>
                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" value="${student.age}" /></td>
                </tr>
                <tr>
                    <td>Mark: </td>
                    <td><input type="text" name="mark" value="${student.mark}" /></td>
                </tr>
                <tr>
                    <td>
                        ClassName:   
                    </td>
                    <td>
                        <select name="className">
                            <c:forEach items="${listClassses}" var="C">
                                <option value="${C.classId}" ${student.classId == C.classId?"selected":""}>${C.className}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update">
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
