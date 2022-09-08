/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Category;
import Model.product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kienb
 */
public class DaoCategory extends DBContext{
    PreparedStatement ptm;
    ResultSet rs;
    
    public List<Category> listAllCategory(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from Type";
        try{
            ptm = getConnection().prepareStatement(sql);
            rs = ptm.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1),rs.getString(2)));
            }
        }catch(Exception e){
            
        }
        return list;
    }

}
