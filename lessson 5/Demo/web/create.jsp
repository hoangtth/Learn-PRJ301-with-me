<%-- 
    Document   : create
    Created on : Apr 22, 2022, 9:18:49 PM
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
            Content: <input type="text" name="content" /><br/>
            To: <select name="to">
                <c:forEach items="${list}" var="A">
                    <c:if test="${A.username != sessionScope.account.username}">
                        <option>${A.username}</option>
                    </c:if>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
