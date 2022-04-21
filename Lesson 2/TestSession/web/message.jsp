<%-- 
    Document   : message
    Created on : Apr 19, 2022, 3:19:02 PM
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
            Content: <input type="text" name="content"><br/>
            To:<select name="to">
                <c:forEach items="${list}" var="A">
                    <c:if test="${A.username != account.username}">
                        <option>${A.username}</option>
                    </c:if>
                </c:forEach>
            </select>
            <input type="submit" name="" value="Save" />    
        </form>
    </body>
</html>
