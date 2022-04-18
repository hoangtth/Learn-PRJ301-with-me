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
import model.Classs;
import model.Student;

/**
 *
 * @author Admin
 */
public class ClassDAO {

    public ArrayList<Classs> getAllClasses() {
         ArrayList<Classs> list = new ArrayList<>();
        try {
            //viet cau query lay allStudents
            String query = " select * from Class";
            //kiem tra ket noi
            Connection conn = new DBContext().getConnection();
            //dung prepareStatement de chuan bi truy suat cau query
            PreparedStatement ps = conn.prepareStatement(query);
            //khi lay select thi se tra ve ResultSet 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classs classs = new Classs(rs.getInt(1), rs.getString(2));
                list.add(classs);
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
