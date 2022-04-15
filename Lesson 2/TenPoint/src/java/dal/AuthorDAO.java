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
import model.Author;
import model.Book;

/**
 *
 * @author Admin
 */
public class AuthorDAO extends DBContext<Author> {

    @Override
    public ArrayList<Author> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Author> getAuthorByBid(int bid) {
        ArrayList<Author> list = new ArrayList<>();
        try {
            String sql = "select * from Author join Book_Author on Author.aid = Book_Author.aid\n"
                    + "  where bid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, bid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Author a = new Author(rs.getInt(1), rs.getString(2));
                list.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insert(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
