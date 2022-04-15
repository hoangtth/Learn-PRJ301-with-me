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
public class Post {

    private int pid;
    private String pcontent;
    private ArrayList<Comment> listComments;

    public Post() {
    }

    public Post(int pid, String pcontent, ArrayList<Comment> listComments) {
        this.pid = pid;
        this.pcontent = pcontent;
        this.listComments = listComments;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public ArrayList<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(ArrayList<Comment> listComments) {
        this.listComments = listComments;
    }

    @Override
    public String toString() {
        return "Post{" + "pid=" + pid + ", pcontent=" + pcontent + ", listComments=" + listComments + '}';
    }
    
    
    
}
