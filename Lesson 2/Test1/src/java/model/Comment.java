/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Comment {
    private int cid;
    private String ccontent;
    private int pid;

    public Comment() {
    }

    public Comment(int cid, String ccontent, int pid) {
        this.cid = cid;
        this.ccontent = ccontent;
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Comment{" + "cid=" + cid + ", ccontent=" + ccontent + ", pid=" + pid + '}';
    }
    
    
    
}
