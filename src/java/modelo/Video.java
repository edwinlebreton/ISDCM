/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.JdbcDerbyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author edwinlebreton
 */
public class Video {
    private int id;
    private String title;
    private String author;
    private Date date;
    private Time duration;
    private int reproductions;
    private String description;
    private String format;
    
    public Video() {
    }
    
    public Video(String title, String author, Date date, Time duration,
            int reproductions, String description,
            String format) {
        
        this.id = generateRandom();
        this.title = title;
        this.author = author;
        this.date = date;
        this.duration = duration;
        this.reproductions = reproductions;
        this.description = description;
        this.format = format;
    }
    
    private int generateRandom(){
        Random rand = new Random();
        int n = rand.nextInt(50000);
        while(randomExists(n)){
            n=rand.nextInt(50000);
        }
        return n;
    }
    
    private boolean randomExists(int n){
        Connection connection = JdbcDerbyConnection.ConexionDB();
        
        String sql = "select * from videos where id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Integer.toString(n));
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return false;
    }
    
    public boolean alreadyExists(){
        Connection connection = JdbcDerbyConnection.ConexionDB();
        
        String sql = "select * from videos where titulo = ?";
 
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, this.title);
            ResultSet rs = pstmt.executeQuery();
            boolean check = false;
            if(rs.next()){
                check=true;
            }
            pstmt.close();
            return check;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return false;
    }
    
    public boolean addVideo(){
        Connection connection = JdbcDerbyConnection.ConexionDB();
        
        String sql = "INSERT INTO VIDEOS VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, this.id);
                pstmt.setString(2, this.title);
                pstmt.setString(3, this.author);
                pstmt.setTime(4, this.duration);
                pstmt.setInt(5, this.reproductions);
                pstmt.setString(6, this.description);
                pstmt.setString(7, this.format);
                pstmt.setDate(8, this.date);
                pstmt.executeUpdate();
                pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        return true;
    }

    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitle(){
        return author;
    }
    
    public void setTitle(String title){
        this.author = title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author){
        this.author = author;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Time getDuration(){
        return duration;
    }
    
    public void setDuration(Time duration){
        this.duration = duration;
    }
    
    public int getReproductions(){
        return reproductions;
    }
    
    public void setReproductions(int reproductions){
        this.reproductions = reproductions;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getFormat(){
        return format;
    }
    
    public void setFormat(String format){
        this.format = format;
    }
}

