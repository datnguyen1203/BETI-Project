/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import Modals.Staff;
import Modals.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhviet171
 */
public class UserDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
      public UserDAO() {
        conn = DBContext.DBContext.getConnection();
    }
    

//    public void createUser(User user) {
//        try (
//                 PreparedStatement statement = conn.prepareStatement("INSERT INTO [User] (userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress) VALUES (?, ?, ?, ?, ?, ?)")) {
//            statement.setString(1, user.getUserEmail());
//            statement.setString(2, user.getUserPassword());
//            statement.setString(3, user.getUserName());
//            statement.setDate(4, user.getUserDayOfBirth());
//            statement.setString(5, user.getUserPhone());
//            statement.setString(6, user.getUserAddress());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
//            // Handle any potential database errors here
//        }
//    }
//
//    public User getUserByID(int userID) {
//        User user = null;
//
//        try (
//                 PreparedStatement statement = conn.prepareStatement("SELECT * FROM [User] WHERE userID = ?")) {
//            statement.setInt(1, userID);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                String userEmail = resultSet.getString("userEmail");
//                String userPassword = resultSet.getString("userPassword");
//                String userName = resultSet.getString("userName");
//                Date userDayOfBirth = resultSet.getDate("userDayOfBirth");
//                String userPhone = resultSet.getString("userPhone");
//                String userAddress = resultSet.getString("userAddress");
//
//                user = new User(userID, userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle any potential database errors here
//        }
//
//        return user;
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//
//        try (
//                 Statement statement = conn.createStatement()) {
//            String query = "SELECT [userID]\n"
//                    + "      ,[userEmail]\n"
//                    + "      ,[userPassword]\n"
//                    + "      ,[userName]\n"
//                    + "      ,[userDayOfBirth]\n"
//                    + "      ,[userPhone]\n"
//                    + "      ,[userAddress]\n"
//                    + "  FROM [dbo].[User]";
//            ResultSet resultSet = statement.executeQuery(query);
//            
//            while (resultSet.next()) {
//                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, 1);
//                int userID = resultSet.getInt("userID");
//                String userEmail = resultSet.getString("userEmail");
//                String userPassword = resultSet.getString("userPassword");
//                String userName = resultSet.getString("userName");
//                Date userDayOfBirth = resultSet.getDate("userDayOfBirth");
//                String userPhone = resultSet.getString("userPhone");
//                String userAddress = resultSet.getString("userAddress");
//                User user = new User(userID, userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress);
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle any potential database errors here
//        }
//
//        return users;
//    }
//
//    public void updateUser(User user) {
//        try (
//                 PreparedStatement statement = conn.prepareStatement("UPDATE [dbo].[User]\n" +
//"   SET [userEmail] = ?\n" +
//"      \n" +
//"      ,[userName] = ?\n" +
//"      ,[userDayOfBirth] = ?\n" +
//"      ,[userPhone] = ?\n" +
//"      ,[userAddress] = ?\n" +
//" WHERE [userID]=?")) {
//            statement.setString(1, user.getUserEmail());
//            statement.setString(2, user.getUserName());
//            statement.setDate(3, user.getUserDayOfBirth());
//            statement.setString(4, user.getUserPhone());
//            statement.setString(5, user.getUserAddress());
//            statement.setInt(6, user.getUserID());
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle any potential database errors here
//        }
//    }
//
//    public void deleteUser(int userID) {
//        try (
//                 PreparedStatement statement = conn.prepareStatement("DELETE FROM [User] WHERE userID = ?")) {
//            statement.setInt(1, userID);
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle any potential database errors here
//        }
//    }

       public User GetUser(String email) {
        User user = new User();
        try {
            ps = conn.prepareStatement("select * from User where userEmail=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("userID"), rs.getString("userEmail"), rs.getString("userPassword"), rs.getString("userName"),
                        rs.getDate("userDayOfBirth"), rs.getString("userPhone"), rs.getString("userAddress"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
      
    public boolean Login(User user) throws SQLException {
        ResultSet rs = null;
        String sql = "Select * from User where userEmail = ? and userPassword=?";
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
}
