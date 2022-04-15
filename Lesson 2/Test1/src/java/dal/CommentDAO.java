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
import model.Comment;

/**
 *
 * @author Admin
 */
public class CommentDAO extends DBContext<Comment> {

    @Override
    public ArrayList<Comment> list() {
        ArrayList<Comment> list = new ArrayList<>();
        try {
            String sql = "  select * from Comment";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<Comment> getCommentsByPid(int pid) {
        ArrayList<Comment> list = new ArrayList<>();
        try {
            String sql = "  select * from Comment where pid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comment c = new Comment(rs.getInt(1), rs.getString(2), rs.getInt(3));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insert(Comment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Comment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Comment model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void insertCommentByPid(int pid, String comment) {
        try {
            String sql = "INSERT INTO [dbo].[Comment]\n"
                    + "           ([ccontent]\n"
                    + "           ,[pid])\n"
                    + "     VALUES\n"
                    + "           (?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, comment);
            stm.setInt(2, pid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
