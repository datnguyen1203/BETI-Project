/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Modals.Staff;
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
public class StaffDAO {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public StaffDAO() {
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

    public Staff GetStaff(String email) {

        try {
            ps = conn.prepareStatement("select * from Staff where staffEmail=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Staff staff = new Staff();
                staff = new Staff(rs.getInt("staffID"), rs.getString("staffEmail"), rs.getString("staffPassword"), rs.getString("staffName"),
                        rs.getDate("staffDayOfBirth"), rs.getString("staffPhone"), rs.getString("staffAddress"));
                return staff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean Login(Staff staff) throws SQLException {
        ResultSet rs = null;
        String sql = "Select * from Staff where staffEmail = ? and staffPassword=?";
        String password = staff.getStaffPassword();
        String hashPassword = hashPassword(password, "MD5");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, staff.getStaffEmail());
            ps.setString(2, hashPassword);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }

        return rs.next();
    }

    public List<Staff> getAllUsers() {
        List<Staff> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("Select * from Staff");
            rs = ps.executeQuery();
            while (rs.next()) {
                Staff staff = new Staff(rs.getInt("staffID"), rs.getString("staffEmail"), rs.getString("staffPassword"), rs.getString("staffName"),
                        rs.getDate("staffDayOfBirth"), rs.getString("staffPhone"), rs.getString("staffAddress"));
                list.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void deleteStaffID(int id) {
        try {
            ps = conn.prepareStatement("DELETE FROM [dbo].[Staff]\n"
                    + "      WHERE staffID = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addStaff(String email, String name, String phone, String address, Date date, String password) {
        try {
            ps = conn.prepareStatement("INSERT INTO [dbo].[Staff]\n"
                    + "           ([staffEmail]\n"
                    + "           ,[staffPassword]\n"
                    + "           ,[staffName]\n"
                    + "           ,[staffDayOfBirth]\n"
                    + "           ,[staffPhone]\n"
                    + "           ,[staffAddress])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setDate(4, date);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStaff(String email, String name, String phone, String address, Date date, String password, String id) {
        try {
            ps = conn.prepareStatement("UPDATE [dbo].[Staff]\n"
                    + "   SET [staffEmail] = ?\n"
                    + "      ,[staffPassword] = ?\n"
                    + "      ,[staffName] = ?\n"
                    + "      ,[staffDayOfBirth] = ?\n"
                    + "      ,[staffPhone] = ?\n"
                    + "      ,[staffAddress] = ?\n"
                    + " WHERE staffID = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setDate(4, date);
            ps.setString(5, phone);
            ps.setString(6, address);
            ps.setInt(7, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
