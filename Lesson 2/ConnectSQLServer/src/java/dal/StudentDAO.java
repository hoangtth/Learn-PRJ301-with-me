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
            // tra ve ResultSet khi va chi khi select ra thoi
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
                list.add(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //lay ra student co id=5
    public Student getStudentHaveId5() {
        try {
            //viet cau query
            String query = "select * from Student where id=5";
            //ket noi voi database
            conn = new DBContext().getConnection();
            //thuc thi cau lenh query vao database
            ps = conn.prepareStatement(query);
            // tra ve ResultSet khi va chi khi select ra thoi
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
                return student;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //lay ra student co id=6
    public Student getStudentHaveId6() {
        try {
            //viet cau query
            String query = "select * from Student where id=6";
            //ket noi voi database
            conn = new DBContext().getConnection();
            //thuc thi cau lenh query vao database
            ps = conn.prepareStatement(query);
            // tra ve ResultSet khi va chi khi select ra thoi
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
                return student;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Student getStudentById(int id) {
        try {
            //viet cau query
            String query = "select * from Student where id=?";
            //ket noi voi database
            conn = new DBContext().getConnection();
            //thuc thi cau lenh query vao database
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            // tra ve ResultSet khi va chi khi select ra thoi
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
                return student;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

    //insert 
    public void insert(Student student) {
        try {
            //viet query de choc vao db
            String query = "INSERT INTO [dbo].[Student]\n"
                    + "           ([name]\n"
                    + "           ,[age]\n"
                    + "           ,[mark]\n"
                    + "           ,[classid])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            //kiem tra ket noi
            conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            ps = conn.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getMark());
            ps.setInt(4, student.getClassId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //update
    public void update(Student student) {
        try {
            //viet query de choc vao db
            String query = "UPDATE [dbo].[Student]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[age] = ?\n"
                    + "      ,[mark] = ?\n"
                    + "      ,[classid] = ?\n"
                    + " WHERE id = ?";
            //kiem tra ket noi
            conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            ps = conn.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getMark());
            ps.setInt(4, student.getClassId());
            ps.setInt(5, student.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //delete
    public void delete(int id) {
        try {
            //viet query de choc vao db
            String query = "DELETE FROM [dbo].[Student]\n"
                    + "      WHERE id = ?";
            //kiem tra ket noi
            conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        StudentDAO sdao = new StudentDAO();
        Student s = sdao.getStudentById(6);
        System.out.println(s);
    }
}
