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

        Server.createWebServer().start();// boots up h2
        Statement stmt = conn.createStatement();

        restaurantsFromRoute1();// calls spark method


        stmt.execute("CREATE TABLE IF NOT EXISTS restaurants (id IDENTITY, name VARCHAR, rating INT, price VARCHAR)");

// since ran before, need to delete the database if made any changes to the table
        // .db file, delete. in project structure
    }

    // When I try to delete this, I get an error. Although I think the below methods
    // should be inside this main method
    //if change schema for database, need to update the database. Easiest way is to run main again and delete current


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

    public static void restaurantsFromRoute1() {

        Spark.init();
        Spark.get(
                // job- get restaurants array list
                "/",
                ((request, response) -> { // gives access to request (from client to server) and response (from server to client)
                    //respons is all of the data that is the homepage
                     // server responsible for generating html
                    // can modify whatever server is sending back (response)
                    // take in requests and manipulate them
                    // request can include cookie key or any attribute
                    // gets the status of the page.Doesnt post to page. Retrieving data.
                    // to handle input from client is post.

                    Session session = request.session();

                    String restaurant = session.attribute("restaurant");

                    // not sure I understand how array lists get called outside of their class.

                    return new ModelAndView(restaurant, "home.html");

                }),
                new MustacheTemplateEngine()
        );
        Spark.post(
                "/create-restaurant",
                ((request, response) -> {
                    String rname = request.queryParams("restaurantName");
                    int rrating  = Integer.valueOf(request.queryParams("restaurantRating"));
                    String rprice$ = request.queryParams("restaurantPriceIn$");

                    Restaurant.insertRestaurant(rname, rrating, rprice$);// values are passed in, not the name


                    response.redirect("/");

                    return "";

                })
        );

//        Spark.post(
//                "/edit-restaurant",
//                ((request, response) -> {
//                    String restaurantName = request.queryParams("restaurantName");
//                    String restaurantRating  = request.queryParams("restaurantRating");
//                    String restaurantPriceIn$ = request.queryParams("restaurantPriceIn$");
//
//                    Restaurant restaurant =
//                            restaurants.get(restaurantName);
//                            restaurants.get(restaurantRating);
//                            restaurants.get(restaurantPriceIn$);
//
//
//                    restaurants.put(restaurantName, restaurant);
//                    restaurants.put(restaurantRating, restaurant);
//                    restaurants.put(restaurantPriceIn$, restaurant);
//                    response.redirect("/");
//                    return "";
//                })
//        );
    }
}









