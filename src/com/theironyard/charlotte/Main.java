package com.theironyard.charlotte;

import org.h2.tools.Server;
import spark.Session;
import spark.Spark;

import java.sql.*;

import static com.theironyard.charlotte.Restaurant.restaurantsFromRoute;


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


    public static void removeArrayList() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        PreparedStatement prestmt = conn.prepareStatement(); //getting an error unless I pass something in here

        prestmt.execute("DELETE * FROM restaurants");


    }
    public static void restaurantsFromRoute1() {

        Spark.init();
        Spark.get(
                "/",
                ((request, response) -> {
                    Session session = request.session();
                    String selectRestaurants = session.attribute("restaurants");
                    Restaurant restaurant = restaurants.get(restaurant);
                    // not sure I understand how array lists get called outside of their class.


                })
        );
    }

}









