/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0017<br>
 * Photographer<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-13    1.0        NangNN           First Version<br>
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * This class configurate to connect data from database
 *
 * @author nangnnhe130538
 */
public class DBContext {

    /**
     * DBContext initial
     */
    private InitialContext initial;
    /**
     * DBContext context
     */
    private Context context;
    /**
     * DBContext dbName
     */
    private String dbName;
    /**
     * DBContext serverName
     */
    private String serverName;
    /**
     * DBContext portNumber
     */
    private String portNumber;
    /**
     * DBContext image
     */
    private String image;
    /**
     * DBContext username
     */
    private String username;
    /**
     * DBContext password
     */
    private String password;

    /**
     * Constructor
     */
    public DBContext() {
        try {
            this.initial = new InitialContext();
            this.context = (Context) initial.lookup("java:comp/env");
            this.serverName = context.lookup("serverName").toString();
            this.dbName = context.lookup("dbName").toString();
            this.portNumber = context.lookup("port").toString();
            this.username = context.lookup("username").toString();
            this.password = context.lookup("password").toString();
            this.image = context.lookup("imagePath").toString();
        } catch (NamingException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get connection of your database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param ps it is a object of <code>java.sql.PreparedStatement</code>
     * @throws Exception
     */
    public void closePreparedStatement(PreparedStatement ps) throws Exception {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param con it is a object of <code>java.sql.Connection</code>
     * @throws Exception
     */
    public void closeConnection(Connection con) throws Exception {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * When you are done with using your connection, you need close in order to
     * release any other database resource
     *
     * @param rs it is a object of <code>java.sql.ResultSet</code>
     * @throws Exception
     */
    public void closeResultSet(ResultSet rs) throws Exception {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * Get path of image store in file context
     *
     * @return path of image
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return image;
    }

}
