package controlador;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexion.JdbcDerbyConnection;
import conexion.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author edwin.lebreton
 */
@WebServlet(urlPatterns = {"/servletUsarios"})
public class servletUsarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private Usuario logInUser(String username, String password) {
        
        Connection connection = JdbcDerbyConnection.ConexionDB();
        
        String sql = "select * from users where username = ? and password= ?";
 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                
                Usuario user = new Usuario();
                
                user.setEmail(rs.getString("email"));
                user.setNombre(rs.getString("name"));
                user.setApellidos(rs.getString("surname"));
                user.setNombreUsuario(rs.getString("username"));
                user.setContrasena(rs.getString("password"));
                
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return null;
    }    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = null;
        
        
        Usuario usr = logInUser(username, password);
            
            if(usr == null){
                message="fail";
            }
            else
                message="success";
        request.setAttribute("message", message);
        request.getRequestDispatcher("/login.jsp").forward(request, response);    
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}