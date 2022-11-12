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

import dao.IShareDAO;
import db.DBContext;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface IShareDAO. <br>
 * This class contains method to query select data from the table Share.<br>
 * There are get all Share.
 *
 * @author nangnnhe130538
 */
public class ShareDAOImpl extends DBContext implements IShareDAO {

    /**
     * Get all Share options according in the database.

     * @return a list <code>Share</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Share> getShare() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "select * from Share";
        ArrayList<Share> shares = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Share share = new Share(getImagePath() + rs.getString("icon"),
                        rs.getString("social_network"), rs.getString("url"));
                shares.add(share);
            }
            return shares;

        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }
}
