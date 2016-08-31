package com.theironyard.charlotte;

import org.h2.tools.Server;

import java.sql.*;


public class Main {

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();

        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        Statement stmt = conn.createStatement();
//        stmt.execute("CREATE TABLE IF NOT EXISTS restaurant (id NUMBER, text VARCHAR, rating INT, price VARCHAR)");
            stmt.execute("DROP TABLE IF EXISTS players");
//        stmt.execute("INSERT INTO players VALUES (NULL, 'Alice', true, 0, 100.0)");
//        PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO players VALUES (NULL, ?, ?, ?, ?)");
//        stmt2.setString(1, "David");
//        stmt2.setBoolean(2, true);
//        stmt2.setInt(3, 0);
//        stmt2.setDouble(4, 100.0);
//        stmt2.execute();

    }
}







