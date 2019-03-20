/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;
import java.sql.Time;

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
    
    public Video(int id, String title, String author,
            Date date, Time duration, int reproductions, String description,
            String format) {
        
        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.duration = duration;
        this.reproductions = reproductions;
        this.description = description;
        this.format = format;
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

