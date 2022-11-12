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

import dao.IGalleryDAO;
import db.DBContext;
import entity.Gallery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This class implements from class interface IGalleryDAO. <br>
 * This class contains method to query select data from the table Gallery.<br>
 * There are get Top 3 Galleries, Get all Galleries, get number Galleries, get
 * Gallery By ID.
 *
 * @author nangnnhe130538
 */
public class GalleryDAOImpl extends DBContext implements IGalleryDAO {

    /**
     * Get top 3 Galleries options according in the database
     *
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Gallery> getTopGalleries(int top) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "Select top (?) * from Gallery";
        ArrayList<Gallery> galleries = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, top);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = getImagePath() + rs.getString("image");
                Gallery gallery = new Gallery(id, name, description, image);
                galleries.add(gallery);
            }
            return galleries;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }

    /**
     * Get all Galleries options according in the database and paging
     *
     * @param pageSize it is an int number.
     * @param pageIndex it is an int number.
     * @return a list <code>Gallery</code> object
     * @throws Exception
     */
    @Override
    public ArrayList<Gallery> getGalleries(int pageSize, int pageIndex) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM (\n"
                + "                SELECT ROW_NUMBER()\n"
                + "                OVER(ORDER BY id) as Number,* FROM Gallery\n"
                + "                )as dbNumber where Number between ? and ?";
        ArrayList<Gallery> galleries = new ArrayList<>();
        try {
            int from = pageSize * (pageIndex - 1) + 1;
            int to = pageSize * pageIndex;

            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, from);
            statement.setInt(2, to);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String image = getImagePath() + rs.getString("image");
                Gallery gallery = new Gallery(id, name, description, image);
                galleries.add(gallery);
            }
            return galleries;
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(statement);
            closeConnection(conn);
        }
    }

    /**
     * Get number of Galleries options according in the database
     *
     * @param pageSize it is an int number.
     * @return an int number.
     * @throws Exception
     */
    public int getNumberPages(int pageSize) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "SELECT COUNT(id) as number FROM Gallery";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                int number = rs.getInt("number");
                if (number % pageSize == 0) {
                    return number / pageSize;
                } else {
                    return number / pageSize + 1;
                }
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
     * Get a Gallery option according in the database by Gallery id
     *
     * @param id it is an int number.
     * @return a <code>Gallery</code> object
     * @throws Exception
     */
    public Gallery getGalleryByID(int id) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        String sql = "select * from Gallery where id = ?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                int galleryId = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                String image = getImagePath() + rs.getString("image");
                Gallery gallery = new Gallery(galleryId, name, des, image);
                return gallery;
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
