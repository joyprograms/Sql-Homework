package com.theironyard.charlotte;

import org.h2.tools.Server;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        Server.createWebServer().start();

        Statement stmt = conn.createStatement();

        stmt.execute("CREATE TABLE IF NOT EXISTS restaurant (id NUMBER, text VARCHAR, rating INT, price VARCHAR)");

        stmt.execute("DROP TABLE IF EXISTS players");
    }// When I try to delete this, I get an error. Although I think the below methods
    // should be inside this main method




    public static void deleteRestaurant() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        PreparedStatement prestmt = conn.prepareStatement(); //getting an error unless I pass something in here

        prestmt.execute("DELETE FROM restaurant WHERE id = '1'");


    }



    public static void removeArrayList () throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        PreparedStatement prestmt = conn.prepareStatement(); //getting an error unless I pass something in here

        prestmt.execute("DELETE * FROM restaurants");




    }
}









