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

import dao.IIntroductionDAO;
import db.DBContext;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This class implements from class interface IIntroductionDAO. <br>
 * This class contains method to query select data from the table
 * Introduction.<br>
 * There are get all Introduction.
 *
 * @author nangnnhe130538
 */
public class IntroductionDAOImpl extends DBContext implements IIntroductionDAO {

    /**
     * Get all Introduction options according in the database.
     *
     * @returna list <code>Introduction</code> object
     * @throws Exception
     */
    @Override
    public Introduction getIntroduction() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "select * from Intro";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                String image = getImagePath() + rs.getString("image");
                String description = rs.getString("descript");
                String aboutMe = rs.getString("aboutme");
                Introduction introduction = new Introduction(image, description, aboutMe);
                return introduction;
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
