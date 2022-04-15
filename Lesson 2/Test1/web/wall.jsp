<%-- 
    Document   : wall
    Created on : Apr 14, 2022, 1:32:57 PM
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
        <c:forEach items="${listPost}" var="P">  
            <form action="wall" method="POST">
                <input type="hidden" name="pid" value="${P.pid}" />
                <h4>${P.pcontent} </h4>
                <c:forEach items="${P.listComments}" var="C">
                    <h6>${C.ccontent}</h6>
                </c:forEach>
                <input type="text" name="comment"/>&nbsp;<input type="submit" value="Save"/>
            </form>
        </c:forEach>       
    </body>
</html>
