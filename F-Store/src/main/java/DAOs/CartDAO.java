/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Modals.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CartDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public CartDAO() {
        //conn = DBContext.DBContext.getConnection();
        conn = DBContext.DBContext.getConnection();
    }

    public int AddNew(Cart c) {
        String sql = "insert into Cart values(?,?,?,?)";
        int ketqua = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getUserID());
            ps.setInt(2, c.getProductID());
            ps.setString(3, c.getSize());
            ps.setInt(4, c.getQuantity());
            ketqua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

    public void delete(int productId) {
        String sql = "delete from [Cart] where productId = ?";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, productId);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Xóa gio hang thành công!");
            } else {
                System.out.println("Không có go hang nào bị xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int update(Cart cart) {
        String sql = "UPDATE Cart SET UserID = ?, ProductID = ?, Size = ?, Quantity = ? WHERE CartID = ?";
        int ketqua = 0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cart.getUserID());
            ps.setInt(2, cart.getProductID());
            ps.setString(3, cart.getSize());
            ps.setInt(4, cart.getQuantity());
            ps.setInt(5, cart.getCartID()); // Cập nhật cho cartID được truyền vào

            ketqua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }

    public ResultSet getAll(int userID) {
        String sql = "SELECT * FROM Cart WHERE UserID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
