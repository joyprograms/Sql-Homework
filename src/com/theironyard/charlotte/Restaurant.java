package com.theironyard.charlotte;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by meekinsworks on 8/31/16.
 */
public class Restaurant {
    public static void insertRestaurant(String restaurantName, int restaurantRating, String restaurantPriceIn$) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
// I believe there is a way to not duplicate line 23, but don't know how and this works.

        PreparedStatement prestmt = conn.prepareStatement("INSERT INTO restaurants VALUES (NULL, ?, ?, ?)"); //getting an error unless I pass something in here
        prestmt.setString(1, restaurantName);
        prestmt.setInt(2, restaurantRating);
        prestmt.setString(3, restaurantPriceIn$);// index it shows up on the table and the value that is passed in from the parameter
        prestmt.execute();

    }

    public static void restaurants(Connection conn) throws SQLException {
    ArrayList<Restaurant> restaurants = new ArrayList<>();


        PreparedStatement prstmt = conn.prepareStatement("");
        ResultSet results = prstmt.executeQuery("SELECT * FROM restaurants");


        while (results.next()) {

            int id = results.getInt("id");
            String text = results.getString("text");
            int rating = results.getInt("rating");
            String price = results.getString("price");
//            restaurants.add(new Restaurant(id, text, rating, price));
            // getting error that the above are arguments and should be parameters.
            // don't know why.
            System.out.printf("%s %s %s\n", id, text, rating, price);

            // says missing return statement. if printf is a return , or returns something,
            // what kind of return statement would I need? 5:23am
        }
//        ArrayList<Restaurant>//(); //  I assume that this is the  the return statement that I need, but then, I have an
        // error about what is not passed in to the parameters here.
        // why am I getting errors about what is passed in? 5:25am


    }

    public static void restaurantsFromRoute () {
        String restaurant;


    }

    public static void updateRestaurant () {




    }
}
