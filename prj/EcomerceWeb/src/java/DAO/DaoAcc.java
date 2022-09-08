/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kienb
 */
public class DaoAcc extends DBContext {

    PreparedStatement ptm;
    ResultSet rs;

    public boolean checkAccountExist(String username, String password) {
        String sql = "select * from account where username = ? and password = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean checkEmailExisted(String email) {
        String sql = "select * from account where email = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, email);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public Account checkUsernameExisted(String uname) {
        String sql = "select * from account where username = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, uname);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getDate(9),rs.getInt(5));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void updatePassword(String otp, String mail) {
        String sql = "update account set password = ? where email = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, otp);
            ptm.setString(2, mail);
            ptm.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void editProfile(String username, String pass, String fullname,String email, String phone, String address, String dob, String accountID) {
        String sql = "update account set username = ?,password = ?,\n"
                + "       email = ?, Phone = ?,FullName = ?,Address = ?,DOB = ?\n"
                + "	   where account_id = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, username);
            ptm.setString(2, pass);
            ptm.setString(3, email);
            ptm.setString(4, phone);
            ptm.setString(5, fullname);
            ptm.setString(6, address);
            ptm.setString(7, dob);
            ptm.setString(8, accountID);
            ptm.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void insertAccount(String name, String password, String email, int i, String phone) {
        String sql = "insert into account(username,password,email,role_id,Phone) values(?,?,?,?,?)";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setString(1, name);
            ptm.setString(2, password);
            ptm.setString(3, email);
            ptm.setInt(4, i);
            ptm.setString(5, phone);
            ptm.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            ptm = getConnection().prepareStatement(sql);
            rs = ptm.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getDate(9),rs.getInt(5)));
            }
        } catch (Exception e) {

        }
        return list;
    }
}
