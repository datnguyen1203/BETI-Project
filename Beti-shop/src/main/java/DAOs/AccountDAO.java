/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DBContext.DBContext;
import Models.User;
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
public class AccountDAO {

    private DBContext con = new DBContext();

    public void createUser(User user) {
        try (
                 PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO [User] (userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, user.getUserEmail());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getUserName());
            statement.setString(4, user.getUserDayOfBirth());
            statement.setString(5, user.getUserPhone());
            statement.setString(6, user.getUserAddress());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, e.getMessage());
            // Handle any potential database errors here
        }
    }

    public User getUserByID(int userID) {
        User user = null;

        try (
                 PreparedStatement statement = con.getConnection().prepareStatement("SELECT * FROM [User] WHERE userID = ?")) {
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String userEmail = resultSet.getString("userEmail");
                String userPassword = resultSet.getString("userPassword");
                String userName = resultSet.getString("userName");
                String userDayOfBirth = resultSet.getString("userDayOfBirth");
                String userPhone = resultSet.getString("userPhone");
                String userAddress = resultSet.getString("userAddress");

                user = new User(userID, userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }

        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (
                 Statement statement = con.getConnection().createStatement()) {
            String query = "SELECT [userID]\n"
                    + "      ,[userEmail]\n"
                    + "      ,[userPassword]\n"
                    + "      ,[userName]\n"
                    + "      ,[userDayOfBirth]\n"
                    + "      ,[userPhone]\n"
                    + "      ,[userAddress]\n"
                    + "  FROM [dbo].[User]";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, 1);
                int userID = resultSet.getInt("userID");
                String userEmail = resultSet.getString("userEmail");
                String userPassword = resultSet.getString("userPassword");
                String userName = resultSet.getString("userName");
                String userDayOfBirth = resultSet.getDate("userDayOfBirth").toString();
                String userPhone = resultSet.getString("userPhone");
                String userAddress = resultSet.getString("userAddress");
                User user = new User(userID, userEmail, userPassword, userName, userDayOfBirth, userPhone, userAddress);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }

        return users;
    }

    public void updateUser(User user) {
        try (
                 PreparedStatement statement = con.getConnection().prepareStatement("UPDATE [dbo].[User]\n" +
"   SET [userEmail] = ?\n" +
"      \n" +
"      ,[userName] = ?\n" +
"      ,[userDayOfBirth] = ?\n" +
"      ,[userPhone] = ?\n" +
"      ,[userAddress] = ?\n" +
" WHERE [userID]=?")) {
            statement.setString(1, user.getUserEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserDayOfBirth());
            statement.setString(4, user.getUserPhone());
            statement.setString(5, user.getUserAddress());
            statement.setInt(6, user.getUserID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }
    }

    public void deleteUser(int userID) {
        try (
                 PreparedStatement statement = con.getConnection().prepareStatement("DELETE FROM [User] WHERE userID = ?")) {
            statement.setInt(1, userID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }
    }

    public int login(String username, String password) {
        int userID = -1;

        try (
                 PreparedStatement statement = con.getConnection().prepareStatement("SELECT userID FROM [User] WHERE username = ? AND userPassword = ?")) {
            statement.setString(1, username);

            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userID = resultSet.getInt("userID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }

        return userID;
    }
}
