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

        while (results.next()) {
            int id = results.getInt("id");
            String text = results.getString("text");
            int rating = results.getInt("rating");
            String price = results.getString("price");
            System.out.printf("%s %s %s\n", id, text, rating, price);

            // says missing return statement. if printf is a return , or returns something,
            // what kind of return statement would I need? 5:23am
        }
        ArrayList<Restaurant>(); // I assume that this is the  the return statement that I need, but then, I have an
        // error about what is not passed in to the parameters here.
        // why am I getting errors about what is passed in?


    }
}







