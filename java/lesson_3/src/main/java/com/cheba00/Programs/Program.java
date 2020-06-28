package com.cheba00.Programs;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws SQLException {
        String dbUser = "postgres";
        String dbPassword = "qwertyu1234567";
        String connectionUrl = "jdbc:postgresql://localhost:5432/fix_users";

        Connection conn = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT  * FROM fix_user");

        while (rs.next()) {
            System.out.println(rs.getString("password"));
        }
    }

}
