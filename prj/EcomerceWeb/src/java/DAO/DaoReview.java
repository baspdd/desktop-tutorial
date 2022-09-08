/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Review;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author kienb
 */
public class DaoReview extends DBContext {

    PreparedStatement ptm;
    ResultSet rs;

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public void insertReview(int accountID, int productID, String contentReview) {
        String query = "insert into Review(account_ID,product_ID,content,date_review) "
                + "values (?,?,?,?)";

        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, accountID);
            ptm.setInt(2, productID);
            ptm.setString(3, contentReview);
            ptm.setDate(4, getCurrentDate());
            ptm.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Review getNewReview(int accountID, int productID) {
        String query = "select top 1 * from Review where account_ID = ? "
                + "and product_ID = ? order by review_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, accountID);
            ptm.setInt(2, productID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return new Review(rs.getInt(5),
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void deleteReviewByProductID(String productID) {
        String query = "delete from Review where product_ID = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, productID);
            ptm.executeUpdate();
        } catch (Exception e) {
        }
    }
}
