<%-- 
    Document   : list
    Created on : Apr 22, 2022, 9:47:48 PM
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
        <table border="1">
            <thead>
                <tr>
                    <th>From</th>
                    <th>Content</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="M">
                    <tr>
                        <td>${M.from}</td>
                        <td>${M.content}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
