<%-- 
    Document   : login
    Created on : 06-mar-2019, 17:06:38
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
  
        <form name="loginform" action="servletUsarios">
        <br><br>
        <table align="center"><tr><td><h2>Login Authentication</h2></td></tr></table>
        <table width="300px" align="center" style="border:1px solid #000000;background-color:#efefef;">
            <tr><td colspan=2></td></tr>
            <tr><td colspan=2>&nbsp;</td></tr>
            <tr>
                <td><b>Nombre de usuario</b></td>
                <td><input type="text" name="username" ></td>
            </tr>
            <tr>
                <td><b>Password</b></td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" name="action" value="login"></td>
            </tr>
            
            <tr>
                <td></td>
                <td><input type="button" name="Register" value="Register" 
                           onclick="window.location.href='registroUsu.jsp';"/></td>
            </tr>
            
            <tr><td colspan=2>&nbsp;</td></tr>
        </table>   
            
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
    </body>
</html>
