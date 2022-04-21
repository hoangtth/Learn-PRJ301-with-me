<%-- 
    Document   : list
    Created on : Apr 15, 2022, 9:16:04 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("are U sure to delete student have id =" + id)) {
                    window.location = "delete-student?studentId=" + id;
                }
            }
        </script>
    </head>
    <body>
        <h2 style="color: red">List Student</h2>
        <a style="margin-left: 280px; padding: 5px 5px; background-color: #ccc;" href="create">Create new</a>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>age</th>
                    <th>mark</th>
                    <th>class name</th>
                    <th>action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listStudents}" var="S">
                    <tr>
                        <td>${S.id}</td>
                        <td>${S.name}</td>
                        <td>${S.age}</td>
                        <td>${S.mark}</td>
                        <td>${S.className}</td>
                        <td><a href="update-student?studentId=${S.id}">Update</a>|<a onclick="doDelete('${S.id}')" href="#">Delete</a>  </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
