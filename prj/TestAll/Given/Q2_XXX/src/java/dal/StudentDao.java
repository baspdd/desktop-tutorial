/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author duypham0705
 */
public class StudentDao {

    public StudentDao() {
        connectDB();
    }

    //Tạo các thành phần để kết nổi và xử lí dữ liệu
    Connection cnn; // Kết nối đến DB
    Statement stm; // Thực thi các câu lệnh SQl
    ResultSet rs; // Lưu trữ và xử lí dữ liệu

    private void connectDB() {
        try {
            cnn = (new DBContext1()).getConnection();
            System.out.println("Connect successfully !");
        } catch (Exception e) {
            System.out.println("Connect error : " + e.getMessage());
        }
    }

    public void Insert(Student s) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strInsert = "insert into Student values('" + s.getId() + "','" + s.getName() + "','" + s.isGender() + "','" + s.getDepartment() + "');";
            stm.executeUpdate(strInsert);
        } catch (Exception e) {
            System.out.println("Isert Error : " + e.getMessage());
        }
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from Student;";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Boolean gender = rs.getBoolean(3);
                int department = rs.getInt(4);
                list.add(new Student(id, name, gender, department));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public boolean checkID(String id) {
        try {
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strSelect = "select * from Student where id ='" + id + "' ";
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login Error : " + e.getMessage());
        }
        return false;
    }

}
