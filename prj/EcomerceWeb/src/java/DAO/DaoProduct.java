/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Review;
import Model.product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kienb
 */
public class DaoProduct extends DBContext {

    PreparedStatement ptm;
    ResultSet rs;

    public List<product> search(int r) {
        List<product> list = new ArrayList<>();
        String sql = "select top " + r + " * from Product where Product.type_id = ?";
        try {
            ptm = getConnection().prepareStatement(sql);
            ptm.setInt(1, 2);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<product> getTop3() {
        List<product> list = new ArrayList<>();
        String sql = "select top 3 * from Product";
        try {
            ptm = getConnection().prepareStatement(sql);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<product> get8Last() {
        List<product> list = new ArrayList<>();
        String query = "select top 8 * from Product order by product_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> get4LaptopLast() {
        List<product> list = new ArrayList<>();
        String query = "select top 4 * from Product where type_id = 1 order by product_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> get4SmartPhoneLast() {
        List<product> list = new ArrayList<>();
        String query = "select top 4 * from Product where type_id = 3 order by product_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public product getLast() {
        String query = "select top 1 * from Product\n"
                + "order by product_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<product> getNext4LapTopProduct(int amount) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where type_id=1\r\n"
                + "order by product_id desc\r\n"
                + "offset ? rows\r\n"
                + "fetch next 4 rows only";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, amount);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getNext4SmartPhoneProduct(int iamount) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where type_id=3\r\n"
                + "order by product_id desc\r\n"
                + "offset ? rows\r\n"
                + "fetch next 4 rows only";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, (iamount - 1) * 4);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getNext3Product(int iamount) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "\r\n"
                + "order by product_id desc\r\n"
                + "offset ? rows\r\n"
                + "fetch next 4 rows only";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, iamount);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getProductByIndex(int indexPage) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product order by product_id offset ? rows fetch next 9 rows only";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, (indexPage - 1) * 9);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int countAllProduct() {
        String query = "select count(*) from Product";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public List<product> getProductByCID(String cateID) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product "
                + "where Product.type_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, cateID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> searchByName(String txtSearch) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product where product_name like ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, "%" + txtSearch + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> searchByPriceMinToMax(int priceMin, int priceMax) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product where price between ? and ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, priceMin);
            ptm.setInt(2, priceMax);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> searchPriceUnder100() {
        List<product> list = new ArrayList<>();
        String query = "select * from Product where price < 100";
        try {
            ptm = getConnection().prepareStatement(query);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public product getProductByID(String id) {
        String query = "Select * from Product where product_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getCateIDByProductID(String id) {
        String query = "Select type_id from Product where product_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public List<product> getRelatedProduct(int cateid) {
        List<product> list = new ArrayList<>();
        String query = "select top 4 * from Product where type_id = ? order by  product_id desc";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setInt(1, cateid);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Review> getAllReviewByProductID(String id) {
        List<Review> list = new ArrayList<>();
        String query = "select * from Review where product_ID = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(5), rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<product> getListProductByAccountid(String account_id, int indexpage) {
        List<product> list = new ArrayList<>();
        String query = "select * from Product where Account_id = ? "
                + "order by product_id offset ? rows "
                + "fetch next 5 rows only";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, account_id);
            ptm.setInt(2, (indexpage - 1) * 5);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int countAllProductByAccountid(String account_id) {
        String query = "select COUNT(*) from Product where Account_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, account_id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void insertProduct(String name, String image, String price, String title, String description,
            String type_id, String account_id, String quantity, String pimage2, String pimage3, String pimage4, String model, String color) {
        String query = "insert into Product(product_name,image,price,title,description,type_id,Account_id,quantity,image2,image3,image4,model,color)\n"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, name);
            ptm.setString(2, image);
            ptm.setString(3, price);
            ptm.setString(4, title);
            ptm.setString(5, description);
            ptm.setString(6, type_id);
            ptm.setString(7, account_id);
            ptm.setString(8, quantity);
            ptm.setString(9, pimage2);
            ptm.setString(10, pimage3);
            ptm.setString(11, pimage4);
            ptm.setString(12, model);
            ptm.setString(13, color);
            ptm.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void deleteProduct(String pid) {
        String query = "delete from Product where product_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, pid);
            ptm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String pid, String name, String image, String price, String title, String description,
            String type_id, String quantity, String pimage2, String pimage3, String pimage4, String model, String color) {
        String query = "update Product set product_name = ?,"
                + "image = ?,"
                + "price = ?,"
                + "title = ?,"
                + "description = ?,"
                + "type_id = ?,"
                + "model = ?,"
                + "color = ?,"
                + "image2=?,"
                + "quantity = ?,"
                + "image3=?,"
                + "image4=?"
                + " where product_id = ?";
        try {
            ptm = getConnection().prepareStatement(query);
            ptm.setString(1, name);
            ptm.setString(2, image);
            ptm.setString(3, price);
            ptm.setString(4, title);
            ptm.setString(5, description);
            ptm.setString(6, type_id);
            ptm.setString(7, model);
            ptm.setString(8, color);
            ptm.setString(9, pimage2);
            ptm.setString(10, quantity);
            ptm.setString(11, pimage3);
            ptm.setString(12, pimage4);
            ptm.setString(13, pid);
            ptm.executeUpdate();
        } catch (Exception e) {
            System.out.println("haha");
        }
    }

}
