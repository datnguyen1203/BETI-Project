/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Modals.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class orderDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public orderDAO() {
        conn = DBContext.DBContext.getConnection();
    }

    //addOrder
    public void addOrder() {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            //Add Order
            String sql = "insert into [order] values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
        } catch (Exception e) {

        }
    }

    //getall
    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [order]";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getFloat(5),
                        rs.getDate(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    //Delete Order
    public int DeleteOrder(int id) {
        int kq = 0;
        String sql = "delete from [Order] where order_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            kq = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
    //get Order
    public int getOrderByAC(int id) {
        rs = null;
        int kq = 0;
        String sql = "select order_id from [order] where account_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                kq = rs.getInt("order_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kq;
    }
}
