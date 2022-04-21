/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Message {
   private int id;
   private String content;
   private String date;
   private String from;
   private String to;

    public Message() {
    }

    public Message(int id, String content, String from, String to) {
        this.id = id;
        this.content = content;
        this.from = from;
        this.to = to;
    }
    
    

    public Message(int id, String content,String date, String from, String to) {
        this.id = id;
        this.date = date ;
        this.content = content;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
   
    
   
}
