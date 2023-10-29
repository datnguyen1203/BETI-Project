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
        conn= DBContext.DBContext.getConnection();
    }
    
     public int AddNew(Cart c) {
        String sql = "insert into Cart values(?,?,?,?)";
        int ketqua = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getMakhachhang());
            ps.setInt(2, c.getMasanpham());
            ps.setString(3, c.getKichthuocsanpham());
            ps.setInt(4, c.getSoluong());
            ketqua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketqua;
    }
}
