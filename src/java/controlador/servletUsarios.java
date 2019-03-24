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
import javax.servlet.http.HttpSession;
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
        String action = request.getParameter("action");
        if("Login".equals(action)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String message = null;
            System.out.println(username+" "+password);
            Usuario usr = new Usuario(username, password);
            if(usr.exists()){
                    message="success";
                    System.out.println(message);
                    HttpSession session = request.getSession(true); 
                    session.setAttribute("userSession", usr);
                    request.getRequestDispatcher("listadoVid.jsp").forward(request, response); 
            }
            else{
                   message="fail";
                   System.out.println(message);
                   request.setAttribute("message", message);
                   request.getRequestDispatcher("/login.jsp").forward(request, response); 
            }
        }
        else if("Registrar".equals(action)){
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatPassword = request.getParameter("repeatPassword");
            Usuario usr = new Usuario(username, name, surname, email, password);
            if(name.equals("")|| surname.equals("") || email.equals("")
                    || username.equals("") || password.equals("") 
                    || repeatPassword.equals("")){
                request.setAttribute("message", "missing fields");
                request.getRequestDispatcher("/registroUsu.jsp").forward(request, response);
            }
            if(!password.equals(repeatPassword)){
                request.setAttribute("message", "wrong password");
                request.getRequestDispatcher("/registroUsu.jsp").forward(request, response); 
            }
            else{
                usr.addUser();

                request.getRequestDispatcher("/login.jsp").forward(request, response); 
            }
            response.sendRedirect("registroUsu.jsp");
        }
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