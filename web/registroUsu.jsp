<%-- 
    Document   : login
    Created on : 06-mar-2019, 17:06:38
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Register user</title>
  
  
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <div class="login-page">
  <div class="form">
    <form class="login-form" action="servletUsarios">
      <input type="text" placeholder="Nombre" class="form-control" name="name" >
      <input type="text" placeholder="Apellidos" class="form-control" name="surname">
      <input type="email" placeholder="Email" class="form-control" name="email">
      <input type="text" placeholder="Nombre de usuario" class="form-control" name="username">
      <input type="password" placeholder="Contraseña" class="form-control" name="password">
      <input type="password" placeholder="Repetir contraseña" class="form-control" name="repeatPassword">
      <button type="submit" name="action" value="Login">Registrar usuario</button>
      <p class="message">¿Ya registrado? <a href="login.jsp">Iniciar Sesión</a></p>
    </form>
  </div>
</div>


</body>

</html>
