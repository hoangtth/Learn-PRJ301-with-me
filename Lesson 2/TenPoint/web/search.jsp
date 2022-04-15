<%-- 
    Document   : search
    Created on : Apr 15, 2022, 1:12:49 PM
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
        <form action="search" method="POST">
            Title: <input type="text" name="title"/><br/>
            Free: <input type="radio"  name="free" value="1" />Free
            <input type="radio" checked="" name="free" value="0" />Not Free
            <input type="radio" name="free" value="2" />Both<br/>
            <input style="margin: 10px 180px " type="submit" value="Search">
        </form> 
        <table >
            <thead>
                <tr>
                    <th>Book title</th>
                    <th>Author name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="B">
                    <tr>
                        <td>
                            ${B.title}
                        </td>
                        <c:forEach items="${B.listAuthors}" var="A">
                        <td>
                           ${A.name} 
                        </td>
                         </c:forEach>
                    </tr>
                   
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
