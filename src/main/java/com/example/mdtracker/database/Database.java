package com.example.mdtracker.database;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.example.mdtracker.database.Const.*;

public class Database {
 /*
 * This class is using the singleton design pattern so that the entire application is only using
 * a single connection
 * */
    // Step 2: Create the only object this class will ever make
    private static Database instance;
    private Connection connection;

    // Step 1: Create a private constructor -> to prevent create different instance
    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME +
                    "?serverTimezone=UTC", DB_USER, DB_PASS);
            System.out.println("Created DB connection");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Step 3: Create a public static
    public static Database getInstance() {
        if(instance == null)
            instance = new Database();
        return instance;
    }
}
