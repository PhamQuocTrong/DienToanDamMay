/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author QUOC-TRONG
 */
public class UsersDAO {
    public boolean checkEmail(String email){
        Connection connection = DBConnect.getConnection();
        String sql = "SELECT * FROM users WHERE user_email = '"+email+"' ";
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                connection.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean insertUser(Users u){
        Connection connection = DBConnect.getConnection();
        String sql = "INSERT INTO users VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, u.getUserID());
            ps.setString(2, u.getUserMail());
            ps.setString(3, u.getUserPass());
            ps.setBoolean(4, u.isUserRole());
            if (ps.executeUpdate()>0) {
                 return true;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Users login(String email, String password){
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM users WHERE user_email = '" + email + "' and user_pass='"+password+"'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Users u = new Users();
                u.setUserID(rs.getLong("user_id"));
                u.setUserMail(rs.getString("user_email"));
                u.setUserPass(rs.getString("user_pass"));
                u.setUserRole(rs.getBoolean("user_role"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
       UsersDAO us=new UsersDAO();
        System.out.println(us.insertUser(new Users(new java.util.Date().getTime(), "tuyendola2@gmail.com", "amamam", true)));
    }
}
