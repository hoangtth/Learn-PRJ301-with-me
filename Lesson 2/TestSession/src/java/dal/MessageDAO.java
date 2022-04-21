/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Message;

/**
 *
 * @author Admin
 */
public class MessageDAO extends DBContext<Message> {

    @Override
    public ArrayList<Message> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Message message) {
        try {
            String sql = "INSERT INTO [dbo].[Message]\n"
                    + "           ([content]\n"
                    + "           ,[from]\n"
                    + "           ,[to])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, message.getContent());
            stm.setString(2, message.getFrom());
            stm.setString(3, message.getTo());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Message model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Message model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Message> getAllMessage(String user) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = " select * from [Message] where [to] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Message mes = new Message(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(mes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        ArrayList<Message> list = new MessageDAO().getAllMessage("user");
        System.out.println(list.get(1).getContent());
    }
    
}
