package com.companionly.prototype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTEST {
    public static void main(String[] args) {

        String credentialsPath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        if (credentialsPath != null) {
            System.out.println("GAC is set to: " + credentialsPath);
        } else {
            System.out.println("GAC is not set.");
        }

        // Test database connection
    String jdbcUrl = "jdbc:mysql://google/ordersDatabase?cloudSqlInstance=awesome-chess-447016-v7:us-central1:awesome-chess-447016-v7&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false";
    String username = "root";
    String password = "root1";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null) {
                System.out.println("Good Connection");
            } else {
                System.out.println("Bad Connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
