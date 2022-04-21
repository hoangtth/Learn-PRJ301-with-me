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

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            //viet cau query lay allStudents
            String query = "select Student.*,classname from Student join Class on Student.classid = Class.classid";
            //kiem tra ket noi
            Connection conn = new DBContext().getConnection();
            //dung prepareStatement de chuan bi truy suat cau query
            PreparedStatement ps = conn.prepareStatement(query);
            //khi lay select thi se tra ve ResultSet 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5), rs.getString(6));
                list.add(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void create(Student student) {
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
            Connection conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getMark());
            ps.setInt(4, student.getClassId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudentById(int studentId) {
        try {
            String query = "DELETE FROM [dbo].[Student]\n"
                    + "      WHERE id = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getStudentById(int studentId) {
        try {
            //viet cau query lay allStudents
            String query = "select * from Student where id = ?";
            //kiem tra ket noi
            Connection conn = new DBContext().getConnection();
            //dung prepareStatement de chuan bi truy suat cau query
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, studentId);
            //khi lay select thi se tra ve ResultSet 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5));
                return student;
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateStudentByID(Student student) {
        try {
            //viet query de choc vao db
            String query = "UPDATE [dbo].[Student]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[age] = ?\n"
                    + "      ,[mark] = ?\n"
                    + "      ,[classid] = ?\n"
                    + " WHERE id = ?";
            //kiem tra ket noi
            Connection conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            PreparedStatement ps = conn.prepareStatement(query);
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

}
