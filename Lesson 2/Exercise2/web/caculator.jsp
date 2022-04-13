<%-- 
    Document   : caculator
    Created on : Apr 13, 2022, 8:30:12 PM
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
        
        
        <form action="caculate">
            <table>
                    <tr>
                        <td>Enter a:</td>
                        <td><input type="text" name="a" value="${a}" /></td>
                    </tr>
                    <tr>
                        <td>Enter b:</td>
                        <td><input type="text" name="b" value="${b}" /></td>
                    </tr>
                    <tr>
                        <td>Caculator</td>
                        <td><select name="operator">
                                <option ${operator eq "+"? "selected":""}>+</option>
                                <option ${operator eq "-"? "selected":""}>-</option>
                                <option ${operator eq "*"? "selected":""}>*</option>
                                <option ${operator eq "/"? "selected":""}>/</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="OK" /></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Result:</td>
                        <td><input type="text" value="${result}" /></td>
                    </tr>
            </table>
                    <h5 style="color: red">${error}</h5>
        </form>
    </body>
</html>
