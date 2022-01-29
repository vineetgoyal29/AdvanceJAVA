package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

        public class TestGet {
	
	    public static void main(String[] args) throws Exception {
		    testget(1);
	}

	    public static void testget(int i) throws Exception {

	   // Step 1: loading MySQL database driver
		Class.forName("com.mysql.jdbc.Driver");
	
	  // Step 2: creating connection with database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","password");
		
	 // Step 3:Executing query via ps object of PreparedStatement Interface
		PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("Select * from employee where id = ?");
		ps.setInt(1, i);
		
	 // process result via the rs object of the ResultSet
	    ResultSet rs = ps.executeQuery();
        
	// fetch all results
        while (rs.next()) 
        	
     {
        System.out.print(" " + rs.getString(1));
		System.out.print(" " + rs.getString(2));
		System.out.print(" " + rs.getString(3));
		System.out.print(" " + rs.getString(4));
		System.out.print(" " + rs.getString(5));
	  }
        
    // Step 4: Closing all the objects to avoid memory leakages
		ps.close();
		rs.close();
		conn.close();
	}

}
