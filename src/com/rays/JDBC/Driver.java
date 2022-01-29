package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Driver {
	public static void main(String[] args) throws Exception {
		
		displayTable();
		updateTable();
		displayTable();
		deleteRecordFromTable();
		displayTable();
		
		
	}

	private static void deleteRecordFromTable() throws Exception {
				//Step 1: loading driver
				Class.forName("com.rays.JDBC.Driver");
				
				//Step 2: creating connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
				//Step 3: Executing query
				Statement stmt = conn.createStatement();
				int i = stmt.executeUpdate("DELETE FROM employee WHERE FIRSTNAME = 'D' ");
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(i + " record(s) Deleted");
	}

	private static void updateTable() throws Exception {
				//Step 1: loading driver
				Class.forName("com.rays.JDBC.Driver");
				
				//Step 2: creating connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
				//Step 3: Executing query
				Statement stmt = conn.createStatement();
				int i = stmt.executeUpdate("INSERT INTO employee VALUES (1002, 'D', 'd', 420, 4)");
				
				System.out.println("  ");
				System.out.println(" ");
				System.out.println(i + " record(s) Inserted");
		
	}

	public static void displayTable() throws Exception {
				//Step 1: loading driver
				Class.forName("com.rays.JDBC.Driver");
				
				//Step 2: creating connection via connection object conn
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
				
				//Step 3: Create Statement Object
				Statement stmt = conn.createStatement();
				
				//Step 4: Executing query via ReaultSet object rs
				ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
				
				//Step 5: Display result by iterating each row of record
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
}
