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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    public Account check(String username, String password) {
        try {
            //viet query de choc vao db
            String query = "select * from Account where username = ? and password = ?";
            //kiem tra ket noi
            Connection conn = new DBContext().getConnection();
            //truy xuat vao db chuan bi thuc thi cau lenh
            PreparedStatement ps = conn.prepareStatement(query);    
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Account account = new Account(rs.getString(2), rs.getString(3));
                return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
