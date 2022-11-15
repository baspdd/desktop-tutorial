/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package dao.impl;

import dao.IInfomationDAO;
import db.DBContext;
import entity.Information;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements from class interface IInfomationDAO. <br>
 * This class contains method to query select data from the table
 * Information.<br>
 * There are get all Information.
 *
 * @author nangnnhe130538
 */
public class InformationDAOImpl extends DBContext implements IInfomationDAO {

    /**
     * Get all Information options according in the database.
     *
     * @returna list <code>Information</code> object
     * @throws Exception
     */
    @Override
    public Information getInfor() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "select * from Information";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                String address = rs.getString("address");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String image = getImagePath() + rs.getString("image");
                
                Information information = new Information(address, city, country, tel, email, image);
                return information;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }

        return null;
    }
}
