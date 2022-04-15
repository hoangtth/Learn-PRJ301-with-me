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
public class BookDAO extends DBContext<Book>{

    @Override
    public ArrayList<Book> list() {
         ArrayList<Book> list = new ArrayList<>();
        try {
            String sql = "select * from Book";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ArrayList<Author> listAuthors = new AuthorDAO().getAuthorByBid(rs.getInt(1));
                Book b = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), listAuthors);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void insert(Book model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Book model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Book model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Book> getBidByTitleAndFree(String title, int free) {
          ArrayList<Book> list = new ArrayList<>();
        try {
            String sql = " select * from Book where title like ? and isFree = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + title + "%");
            stm.setInt(2, free);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ArrayList<Author> listAuthors = new AuthorDAO().getAuthorByBid(rs.getInt(1));
                Book b = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), listAuthors);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    
    
     public ArrayList<Book> getBidByTitleAndFreeBoth(String title) {
          ArrayList<Book> list = new ArrayList<>();
        try {
            String sql = " select * from Book where title like ? and isFree = 1 or isFree = 0";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + title + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ArrayList<Author> listAuthors = new AuthorDAO().getAuthorByBid(rs.getInt(1));
                Book b = new Book(rs.getInt(1), rs.getString(2), rs.getInt(3), listAuthors);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    } 
    public static void main(String[] args) {
        ArrayList<Book> list = new BookDAO().getBidByTitleAndFree("b", 1);
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
