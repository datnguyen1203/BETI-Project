/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modals.Product;
import Modals.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author uchih
 */
public class ProductDAO {

    
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProductDAO() {
        con = DBContext.DBContext.getConnection();
    }

    public ResultSet getAllProduct() {
        String sql = "select*from Product";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public void addProduct(String productName, String productPrice, String productQuantity, String productImg, String productMaterial, String productType) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "([productName]\n"
                + ",[productPrice]\n"
                + ",[productQuantity]\n"
                + ",[productImg]\n"
                + ",[productMaterial]\n"
                + ",[productType])\n"
                + "VALUES\n"
                + "(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            // Thiết lập các giá trị thay thế trong câu SQL
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productPrice);
            preparedStatement.setString(3, productQuantity);
            preparedStatement.setString(4, productImg);
            preparedStatement.setString(5, productMaterial);
            preparedStatement.setString(6, productType);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Thêm sản phẩm thành công.");
            } else {
                System.out.println("Không thể thêm sản phẩm.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String productName, String productPrice, String productQuantity, String productImg, String productMaterial, String productType, String id) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [productName] = ?,\n"
                + "      [productPrice] = ?,\n"
                + "      [productQuantity] = ?,\n"
                + "      [productImg] = ?,\n"
                + "      [productMaterial] = ?,\n"
                + "      [productType] = ?\n"
                + " WHERE productID = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productPrice);
            preparedStatement.setString(3, productQuantity);
            preparedStatement.setString(4, productImg);
            preparedStatement.setString(5, productMaterial);
            preparedStatement.setString(6, productType);
            preparedStatement.setString(7, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật sản phẩm thành công!");
            } else {
                System.out.println("Không có sản phẩm nào được cập nhật.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public Product GetProductId(String id) {
        Product p = new Product();
        try {
            ps = con.prepareStatement("select * from [Product] where productID=?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Product(rs.getInt("productID"), rs.getString("productName"), rs.getDouble("productPrice"), rs.getInt("productQuantity"),
                        rs.getString("productImg"), rs.getString("productCategory"), rs.getString("productDis"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public void deleteProduct(String productId) {
        String sql = "DELETE FROM [dbo].[Product] WHERE productID = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, productId);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Xóa sản phẩm thành công!");
            } else {
                System.out.println("Không có sản phẩm nào bị xóa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
