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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    public Account check(String username, String password) {
         try {
            String sql = "select * from Account where username= ? and password = ?";
            //mo ket not
             Connection conn = new DBContext().getConnection();
            //dua cau lenh sql vao prepare de chuan bi thuc thi
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1, username);
             ps.setString(2, password);
            //thuc thi va tra ve ket qua
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Account account = new Account(rs.getString(1), rs.getString(2));
               return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> list() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            String sql = "select * from Account";
            //mo ket not
             Connection conn = new DBContext().getConnection();
            //dua cau lenh sql vao prepare de chuan bi thuc thi
             PreparedStatement ps = conn.prepareStatement(sql);
            //thuc thi va tra ve ket qua
             ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Account account = new Account(rs.getString(1), rs.getString(2));
               list.add(account);
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
