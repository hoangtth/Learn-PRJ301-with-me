/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Book {
    private int bid;
    private String title;
    private int isFree;
    private ArrayList<Author> listAuthors;

    public Book() {
    }

    public Book(int bid, String title, int isFree, ArrayList<Author> listAuthors) {
        this.bid = bid;
        this.title = title;
        this.isFree = isFree;
        this.listAuthors = listAuthors;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsFree() {
        return isFree;
    }

    public void setIsFree(int isFree) {
        this.isFree = isFree;
    }

    public ArrayList<Author> getListAuthors() {
        return listAuthors;
    }

    public void setListAuthors(ArrayList<Author> listAuthors) {
        this.listAuthors = listAuthors;
    }

    @Override
    public String toString() {
        return "Book{" + "bid=" + bid + ", title=" + title + ", isFree=" + isFree + ", listAuthors=" + listAuthors + '}';
    }
    
    
    
    
    
}
