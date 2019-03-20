<%-- 
    Document   : registroUsu
    Created on : 06-mar-2019, 17:46:58
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form name="loginform" method="get" action="servletUsarios">
        <br><br>
        <table align="center"><tr><td><h2>Registro usuarios</h2></td></tr></table>
        <table width="300px" align="center" style="border:1px solid #000000;background-color:#efefef;">
            <tr><td colspan=2></td></tr>
            <tr><td colspan=2>&nbsp;</td></tr>
            <tr>
                <td><b>Nombre</b></td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td><b>Apellidos</b></td>
                <td><input type="text" name="surname"></td>
            </tr>
            <tr>
                <td><b>Correo electrónico</b></td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><b>Nombre usuario</b></td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td><b>Contrasena</b></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><b>Repetir contrasena</b></td>
                <td><input type="password" name="repeatPassword"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" name="action" value="Registrar"></td>
            </tr>
            
            <tr><td colspan=2>&nbsp;</td></tr>
        </table> 
        <c:if test="${not empty message}">
            <h1>${message}</h1>
        </c:if>
    </body>
</html>
