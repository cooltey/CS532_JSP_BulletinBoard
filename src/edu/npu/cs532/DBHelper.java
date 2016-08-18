package edu.npu.cs532;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper{
	// CS532
	// Feng, Pi - Hao
	// 18841

    
    // connect to db
    public static Connection getConnection() {
    	Connection connection = null;
	    try {
	        // Load the JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Driver loaded");
	
	        // Establish a connection
	        connection = DriverManager.getConnection("jdbc:mysql://localhost/cs532_project", "root", "");
	        System.out.println("Database connected");
	
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    
	    return connection;
    }
}
