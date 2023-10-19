/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DBContext.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modals.Product;
import java.sql.PreparedStatement;

/**
 *
 * @author uchih
 */
public class ProductDAO {

    private DBContext con = new DBContext();

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (
                 Statement statement = con.getConnection().createStatement()) {
            String query = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int productID = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");
                int productQuantity = resultSet.getInt("productQuantity");
                String productImg = resultSet.getString("productImg");
                String productMaterial = resultSet.getString("productMaterial");
                String productType = resultSet.getString("productType");
                Product product = new Product(productID, productName, productPrice, productQuantity, productImg, productMaterial, productType);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors here
        }

        return products;
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
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);

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
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);

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

    public Product getProductById(int id) {
        Product product = null;

        try {
            String query = "SELECT * FROM Product WHERE productId = ?";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int productID = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");
                int productQuantity = resultSet.getInt("productQuantity");
                String productImg = resultSet.getString("productImg");
                String productMaterial = resultSet.getString("productMaterial");
                String productType = resultSet.getString("productType");

                product = new Product(productID, productName, productPrice, productQuantity, productImg, productMaterial, productType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public void deleteProduct(String productId) {
        String sql = "DELETE FROM [dbo].[Product] WHERE productID = ?";

        try {
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);

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

    public static void main(String[] args) {
        ProductDAO d = new ProductDAO();
//        List<Product> products = new ArrayList<>();
//        products = d.getAllProducts();
//        for (Product p : products) {
//            System.out.println(p.toString());
//        }
//        System.out.println(d.getAllProducts().get(1).toString());
        System.out.println(d.getProductById(1).toString());
//        String productName = "test";
//            String productPrice =  "1";
//            String productQuantity =  "1";
//            String productImg =  "test";
//            String productMarterial =  "test";
//            String productType =  "test";
//            d.addProduct(productName, productPrice, productQuantity, productImg, productMarterial, productType);

    }
}
