package Context;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Context.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author duypham0705
 */
public class UserDAO {

    public UserDAO() {
        connectDB();
    }

    // Tạo các thành phần để kết nổi và xử lí dữ liệu
    Connection cnn; // Kết nối đến DB
    Statement stm; // Thực thi các câu lệnh SQl
    ResultSet rs; // Lưu trữ và xử lí dữ liệu

    private void connectDB() {
        try {
            cnn = (new DBContext()).getConnection();
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public boolean checkInum(int n) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblNumber where iNum ='" + n + "' ";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error : " + e.getMessage());
        }
        return false;
    }

    public boolean checkInumFor(int n,int ex) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblNumber where iNum ='" + n + "'and ex ='" + ex + "' ";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error : " + e.getMessage());
        }
        return false;
    }

    public String getResult(int n, int ex) {
        String ret = "";
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from tblNumber where iNum ='" + n + "'and ex ='"+ex+"'" ;
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                ret = rs.getString(2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    public void update(int n, String result, int ex) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strUpdate = "update tblNumber set sResult = '" + result + "' where iNum ='" + n + "'and ex ='" + ex + "'";
            stm.execute(strUpdate);
        } catch (Exception e) {
            System.out.println("Update Error : " + e.getMessage());
        }
    }

    public void insert(int n, String result,int ex) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strInsert = "insert into tblNumber (iNum,sResult,ex) values('" + n + "','" + result + "','" + ex + "');";
            stm.executeUpdate(strInsert);
        } catch (Exception e) {
            System.out.println("Isert Error : " + e.getMessage());
        }
    }

}
