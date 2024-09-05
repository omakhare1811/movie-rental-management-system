package com.cts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String url = "jdbc:mysql://localhost:3306/job_portal";
    public static final String username = "root";
    public static final String password = "root123";


    // This getConnection method will help in connection with our actual mysql database using the above credentials
       public static Connection getConnection(){
           try {
               return DriverManager.getConnection(url,username,password);
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
}
