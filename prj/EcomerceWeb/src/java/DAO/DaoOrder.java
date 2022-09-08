/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kienb
 */
public class DaoOrder extends DBContext {

    PreparedStatement ptm;
    ResultSet rs;

    public void insertOrder(String account_id, String product_id, int quantity) {
        String sql = "insert into "
                + "[Order](account_id,product_id,[quantity])\n"
                + "values (?,?,?)";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, account_id);
            ptm.setString(2, product_id);
            ptm.setInt(3, quantity);
            ptm.executeUpdate();
            ptm.close();
        } catch (Exception e) {

        }
    }
}
