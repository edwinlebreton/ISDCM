/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author edwinlebreton
 */
public class Usuario {
  
   /*
    * Attributes
    */
    
    private String nombre;
    private String apellidos;
    private String email;
    private String nombre_usario;
    private String contrasena;
    
    public Usuario() {
    }
    
    public Usuario(String nombre_usario, String nombre, String apellidos,
            String email, String contrasena) {
        
        this.nombre_usario = nombre_usario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.contrasena = contrasena;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombreUsuario(){
        return nombre_usario;
    }
    
    public void setNombreUsuario(String nombre){
        this.nombre_usario = nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getContrasena(){
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
}
