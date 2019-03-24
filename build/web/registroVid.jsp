<%-- 
    Document   : registroVid
    Created on : 06-mar-2019, 17:47:17
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Register video</title>
  
  
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="css/style2.css">

  
</head>

<body>

  <div class="form">
    <form class="login-form" action="servletRegistroVid">
      <h1 align="center">Registrar video</h1>
      <input type="number" placeholder="id" name="id" >
      <input type="text" placeholder="Titulo" name="title">
      <input type="text" placeholder="Autor" name="author">
      <input type="time" placeholder="Duracion" name="duration">
      <input type="number" placeholder="Reproducciones" name="reproductions">
      <input type="text" placeholder="Descripcion" name="description">
      <input type="text" placeholder="Formato" name="format">
      <button type="submit" name="action" value="registrarVid">Registrar video</button>
      <p class="message"><a href="listadoVid.jsp">Volver a listado de video</a></p>
    </form>
  </div>
</div>
<%
if(session.getAttribute("userSession")==null)
                    response.sendRedirect("login.jsp");
%>
</body>

</html>
