<%-- 
    Document   : listadoVid
    Created on : 06-mar-2019, 17:47:31
    Author     : edwin.lebreton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import= "conexion.JdbcDerbyConnection" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Videos</title>
        <link rel="stylesheet" href="css/table.css">
    </head>
    <body>
            <%
            if(session.getAttribute("userSession")==null)
                    response.sendRedirect("login.jsp");
            %>
            <%
                if(request.getAttribute("message") != null && request.getAttribute("message") != ""){
            %>
                <p style="color:white"> ${message}</p>
            <%
                }
            %>
            <h1>Lista de Videos</h1>
            <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Titulo</th>
                  <th>Autor</th>
                  <th>Fecha de creacion</th>
                  <th>Duracion</th>
                  <th>Reproducciones</th>
                  <th>Descripcion</th>
                  <th>Formato</th>
                </tr>
              </thead>
            </table>
          </div>
            <%
            try {
                Connection connection = JdbcDerbyConnection.ConexionDB();
                String sql = "select * from VIDEOS";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                %>
                <div class="tbl-content">
                <TABLE cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                <%
                while (rs.next()) {
                %>
                <TR>
                <TD><%=rs.getInt(1)%></TD>
                <TD><%=rs.getString(2)%></TD>
                <TD><%=rs.getString(3)%></TD>
                <TD><%=rs.getDate(8)%></TD>
                <TD><%=rs.getTime(4)%></TD>
                <TD><%=rs.getInt(5)%></TD>
                <TD><%=rs.getString(6)%></TD>
                <TD><%=rs.getString(7)%></TD>
                </TR>
                <% } %>
                <%
                // close all the connections.
                rs.close();
                statement.close();
                connection.close();
            } catch (Exception ex) {
                %>
                </font>
                <font size="+3" color="red"></b>
                <%
                out.println("Unable to connect to database.");
                }
                %>
            </TABLE>
            </tbody>
            </div>
            </font>
        <button type="submit" name="action" value="registerNewVid" onclick="parent.location='registroVid.jsp'" >Añadir nueva video</button>    
    </body>
</html>
