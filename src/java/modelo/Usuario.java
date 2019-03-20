/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.JdbcDerbyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edwinlebreton
 */
public class Usuario {
  
   /*
    * Attributes
    */
    
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    
    public Usuario() {
    }
    
    public Usuario(String username, String name, String surname,
            String email, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    
    public boolean addUser(){
        Connection connection = JdbcDerbyConnection.ConexionDB();
        
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, this.username);
                pstmt.setString(2, this.password);
                pstmt.setString(3, this.name);
                pstmt.setString(4, this.surname);
                pstmt.setString(5, this.email);
                pstmt.executeUpdate();
                pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }
    
    public String getNombre(){
        return name;
    }
    
    public void setNombre(String name){
        this.name = name;
    }
    
    public String getNombreUsuario(){
        return username;
    }
    
    public void setNombreUsuario(String username){
        this.username = username;
    }
    
    public String getApellidos(){
        return surname;
    }
    
    public void setApellidos(String surname){
        this.surname = surname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getContrasena(){
        return password;
    }
    
    public void setContrasena(String password){
        this.password = password;
    }
    
}
