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

import dao.INumberOfViewsDao;
import db.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements from class interface IIntroductionDAO. <br>
 * This class contains method to query select data from the table
 * NumberOfViews.<br>
 * There are get view count of page and update view count of page.
 *
 * @author nangnnhe130538
 */
public class NumberOfViewsDaoImpl extends DBContext implements INumberOfViewsDao {

    /**
     * Get number of view from NumberOfViews table in database
     *
     * @return number of view
     * @throws java.lang.Exception
     */
    @Override
    public int getNumber() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "select * from NumberOfViews";
        try {
            conn = new DBContext().getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumOfViews");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
        return -1;
    }

    /**
     * Update number of view when user access web page many times
     *
     * @throws java.lang.Exception
     */
    @Override
    public void updateNumber() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update NumberOfViews set NumOfViews = NumOfViews + 1";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConnection(con);

        }
    }

}
