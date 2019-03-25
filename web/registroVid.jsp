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
      <%
        if(request.getAttribute("message") != null && request.getAttribute("message") != ""){
            if((request.getAttribute("videoAlreadyExists"))==null){
                %>
                <p style="color:green"> ${message}</p>
                <%
                    }
            else{        
      %>
        <p style="color:red"> ${message}</p>
      <%
          }
        }
      %>
      <input type="number" required='required' placeholder="id" name="id" >
      <input type="text" required='required' placeholder="Titulo" name="title">
      <input type="text" required='required' placeholder="Autor" name="author">
      <input type="date" required='required' placeholder="Fecha de creacion" name="date">
      <input type="time" required='required' step="1" placeholder="Duracion" name="duration">
      <input type="number" required='required' placeholder="Reproducciones" name="reproductions">
      <input type="text" required='required' placeholder="Descripcion" name="description">
      <input type="text" required='required' placeholder="Formato" name="format">
      <button type="submit" name="action" value="registrarVid">Registrar video</button>
      <p class="message"><a href="listadoVid.jsp">Volver a listado de video</a></p>
    </form>
  </div>
<%
if(session.getAttribute("userSession")==null)
                    response.sendRedirect("login.jsp");
%>
</body>

</html>
