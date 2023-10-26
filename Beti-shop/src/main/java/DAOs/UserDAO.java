/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Modals.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public UserDAO() {
        conn = DBContext.DBContext.getConnection();
    }
    
    public String hashPassword(String password, String algorithm) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(password.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashedBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public User GetUser(String email) {
        User user = new User();
        try {
            ps = conn.prepareStatement("select * from [User] where userEmail=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("userID"), rs.getString("userEmail"), rs.getString("userPassword"), rs.getString("userName"),
                        rs.getDate("userDayOfBirth"), rs.getString("userPhone"), rs.getString("userAddress"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select * from [User]");
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("userID"), rs.getString("userEmail"), rs.getString("userPassword"), rs.getString("userName"),
                        rs.getDate("userDayOfBirth"), rs.getString("userPhone"), rs.getString("userAddress"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean Login(User user) throws SQLException {
        ResultSet rs = null;
        String sql = "Select * from [User] where userEmail = ? and userPassword=?";
        String password = user.getUserPassword();
        String hashPassword = hashPassword(password, "MD5");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserEmail());
            ps.setString(2, hashPassword);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }

        return rs.next();
    }

    public void deleteUser(int id){
        try {
            ps = conn.prepareStatement("DELETE FROM [dbo].[User]\n" +
                    "      WHERE userID = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(int id, String email, String name, String phone, String address, Date date) {
        try {
            ps = conn.prepareStatement("UPDATE [dbo].[User]\n" +
                    "   SET [userEmail] = ?\n" +
                    "      ,[userName] = ?\n" +
                    "      ,[userDayOfBirth] = ?\n" +
                    "      ,[userPhone] = ?\n" +
                    "      ,[userAddress] = ?\n" +
                    " WHERE userID = ?");
            ps.setString(1,email);
            ps.setString(2,name);
            ps.setDate(3,date);
            ps.setString(4,phone);
            ps.setString(5,address);
            ps.setInt(6,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addUser(String email, String name, String phone, String address, Date date,String password) {
        try {
            ps = conn.prepareStatement("INSERT INTO [dbo].[User]\n" +
                    "           ([userEmail]\n" +
                    "           ,[userPassword]\n" +
                    "           ,[userName]\n" +
                    "           ,[userDayOfBirth]\n" +
                    "           ,[userPhone]\n" +
                    "           ,[userAddress])\n" +
                    "     VALUES\n" +
                    "           (?,?,?,?,?,?)");
            ps.setString(1,email);
            ps.setString(1,password);
            ps.setString(3,name);
            ps.setDate(4,date);
            ps.setString(5,phone);
            ps.setString(6,address);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
