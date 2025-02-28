package com.companionly.prototype;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDriver {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://google/ordersDatabase?cloudSqlInstance=awesome-chess-447016-v7:us-central1:awesome-chess-447016-v7&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false";
            String username = "root";
            String password = "root1";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
