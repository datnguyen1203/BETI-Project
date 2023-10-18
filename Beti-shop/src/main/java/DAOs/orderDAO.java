/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

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
    public void addOrder(){
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try{
            //Add Order
            String sql = "insert into [order] values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 0);
        }
        catch (Exception e){
            
        }
    }
}
