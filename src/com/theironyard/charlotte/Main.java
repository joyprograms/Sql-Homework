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


    public static void insertRestaurant() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
// I believe there is a way to not duplicate line 23, but don't know how and this works.

        PreparedStatement prestmt = conn.prepareStatement(); //getting an error unless I pass something in here

        prestmt.execute("INSERT INTO restaurant (1, 'Burgers N Beans', 3, $)");

        prestmt.execute("INSERT INTO restaurant VALUES (2, Hashtag Hashbrowns and Things, 4, $$)");

        prestmt.execute("INSERT INTO restaurant VALUES (3, Brownies and Beanies, 2, $)");

        prestmt.execute("INSERT INTO restaurant VALUES (4, CleanEatsX2, 5, $$)");

    }

    public static void deleteRestaurant() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        PreparedStatement prestmt = conn.prepareStatement(); //getting an error unless I pass something in here

        prestmt.execute("DELETE FROM restaurant WHERE id = '1'");


    }

    public static ArrayList <Restaurant> selectRestaurants(Connection conn) throws  SQLException {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        PreparedStatement prstmt = conn.prepareStatement();

        ResultSet results = prstmt.executeQuery("SELECT * FROM restaurants");


    }
}







