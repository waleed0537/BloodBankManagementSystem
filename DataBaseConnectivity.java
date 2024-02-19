package com.example.demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBaseConnectivity {
    public Connection databaseLink;

    public Connection getConnection() {
        String databasename = "Bloodbank";
        String databaseuser = "root";
        String databasepassword = "Waleed789.";
        String url = "jdbc:mysql://localhost/" + databasename;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseuser,databasepassword);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
        return databaseLink;
    }


}
