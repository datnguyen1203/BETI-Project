/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class cartDAO {
       private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public cartDAO() {
        //conn = DBContext.DBContext.getConnection();
        conn= DBContext.DBContext.getConnection();
    }
}
