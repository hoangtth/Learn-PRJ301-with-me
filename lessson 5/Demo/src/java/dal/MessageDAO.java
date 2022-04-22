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
import model.Message;

/**
 *
 * @author Admin
 */
public class MessageDAO {

    public void insert(Message message) {
        try {
            String sql = "INSERT INTO [dbo].[Message]\n"
                    + "           ([content]\n"
                    + "           ,[from]\n"
                    + "           ,[to])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            //mo ket not
            Connection conn = new DBContext().getConnection();
            //dua cau lenh sql vao prepare de chuan bi thuc thi
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, message.getContent());
            ps.setString(2, message.getFrom());
            ps.setString(3, message.getTo());
            //thuc thi va tra ve ket qua
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Message> list() {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select * from Message";
            //mo ket not
            Connection conn = new DBContext().getConnection();
            //dua cau lenh sql vao prepare de chuan bi thuc thi
            PreparedStatement ps = conn.prepareStatement(sql);
            //thuc thi va tra ve ket qua
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Message message = new Message(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(message);
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
