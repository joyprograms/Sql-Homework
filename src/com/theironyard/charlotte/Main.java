package com.theironyard.charlotte;

import org.h2.tools.Server;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.sql.*;
import java.util.HashMap;


public class Main {
//    ArrayList<Restaurant> restaurants = new ArrayList<>();
    HashMap<String, Restaurant>  restaurants = new HashMap<>();


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

        PreparedStatement prestmt = conn.prepareStatement(""); //getting an error unless I pass something in here

        prestmt.execute("DELETE FROM restaurant WHERE id = '1'");


    }


    public static void removeArrayList() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");

        PreparedStatement prestmt = conn.prepareStatement(""); //getting an error unless I pass something in here

        prestmt.execute("DELETE * FROM restaurants");


    }
    public void restaurantsFromRoute1() {

        Spark.init();
        Spark.get(
                // job- get restaurants array list
                "/",
                ((request, response) -> {
                    Session session = request.session();

                    String restaurant = session.attribute("restaurant");

                    // not sure I understand how array lists get called outside of their class.

                    return new ModelAndView(restaurant, "home.html");

                }),
                new MustacheTemplateEngine()
        );

        Spark.post(
                "/edit-restaurant",
                ((request, response) -> {
                    String restaurantName = request.queryParams("restaurantName");
                    String restaurantRating  = request.queryParams("restaurantRating");
                    String restaurantPriceIn$ = request.queryParams("restaurantPriceIn$");

                    Restaurant restaurant =
                            restaurants.get(restaurantName);
                            restaurants.get(restaurantRating);
                            restaurants.get(restaurantPriceIn$);


                    restaurants.put(restaurantName, restaurant);
                    restaurants.put(restaurantRating, restaurant);
                    restaurants.put(restaurantPriceIn$, restaurant);




                    response.redirect("/");
                    return "";


        }
        )

        );


    }

}









