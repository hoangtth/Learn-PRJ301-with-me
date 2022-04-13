/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            //viet cau query
            String query = "select * from Student";
            //ket noi voi database
            conn = new DBContext().getConnection();
            //thuc thi cau lenh query vao database
            ps = conn.prepareStatement(query);
            // khi chung ta lay ra cai gi hay select cai gi thi no se tra ve 1 resultSet
            //khi lay ra cai gi thi la executeQuery , lay ra cai gi o day k lam thay doi database
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(4));
                list.add(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public static void main(String[] args) {
       StudentDAO studentDAO = new StudentDAO();
       ArrayList<Student> list = studentDAO.getAllStudents();
        for (Student student : list) {
            System.out.println(student);
        }
    }

}
