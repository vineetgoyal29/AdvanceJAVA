package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatementProgram {
	public static void main(String[] args) throws Exception {
		
		
		displayTable();
		updateTable();
		displayTable();
	}

	private static void displayTable() throws Exception {
		//Step 1: loading driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		
		//Step 3: Executing query
		Statement stmt = conn.createStatement();
		
		//Step 4: Executing query and displaying result
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
		
		//Step 5: iterating each row of record
		while (rs.next()){
			System.out.println(" ");
			System.out.print("  " + rs.getString(1));
			System.out.print("  " + rs.getString(2));
			System.out.print("  " + rs.getString(3));
			System.out.print("  " + rs.getString(4));
			System.out.print("  " + rs.getString(5));
			
		}
		
		//Step 6: Closing the resources
		stmt.close();
		conn.close();
		rs.close();
		
	}
	
	private static void updateTable() throws Exception {
		
		int id = 15;
		String fn = "Virendra";
		String ln = "Shewag";
		int sal = 18000;
		int dId = 7;
		
		//Step 1: loading driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: creating connection by connection object conn
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3:Creating PreparedStatement object (ps) and Executing query
		PreparedStatement ps = conn.prepareStatement("INSERT INTO employee values (?,?,?,?,?)");
		
		ps.setInt(1, id);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setInt(4, sal);
		ps.setInt(5, dId);
		
		// Step 4: closing objects
		conn.close();
		ps.close();
}
}
