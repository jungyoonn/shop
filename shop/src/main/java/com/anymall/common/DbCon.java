package com.anymall.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCon {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void connectDatabase() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try{
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ANYMALL", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        stmt = con.createStatement();
    }

    public static void closeDatabase() throws SQLException {
        rs.close();
        stmt.close();
        con.close();
    }

    public static ResultSet query(String query) throws SQLException{
        rs = stmt.executeQuery(query);
        return rs;
    }

    public static void queryUpdate(String query) throws SQLException {
        stmt.executeUpdate(query);
    }
}
