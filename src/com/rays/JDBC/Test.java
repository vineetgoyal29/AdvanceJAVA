package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws Exception {
		//displayTable();
		//addRecord();
		displayTable();
		deleteRecord();
		displayTable();
	}

	private static void deleteRecord() throws Exception {
		//Step 1: Load MySQL Driver
		Class.forName("com.rays.JDBC.Driver");
						
		//Step 2: create Database connection
		Connection conn = DriverManager.getConnection("JDBC:mysql://localhost/rays", "root", "password");
					
		//Step 3: Create Statement object
		Statement stmt = conn.createStatement();
		
		//Step 4: Execute Query via int object i
		int i = stmt.executeUpdate("DELETE FROM employee WHERE id = 12");
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(i + " Record(s) Deleted");
		
		//Step 5: closing objects
		stmt.close();
		conn.close();
		
		
	}

	private static void addRecord() throws Exception {
		//Step 1: Load MySQL Driver
		Class.forName("com.rays.JDBC.Driver");
				
		//Step 2: create Database connection
		Connection conn = DriverManager.getConnection("JDBC:mysql://localhost/rays", "root", "password");
				
		//Step 3: Create Statement object
		Statement stmt = conn.createStatement();
					
		//Step 4: Execute Query via int object i
		int i = stmt.executeUpdate("INSERT INTO employee VALUES (12542, 'checking_3', 'additonalField_3', 12014, null)");
		System.out.println(" ");
		System.out.println(i +" Record(s) inserted");
		System.out.println(" ");
		
		//Step 5: closing the objects
		stmt.close();
		conn.close();
	}

	private static void displayTable() throws Exception {
		//Step 1: Load MySQL Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: create Database connection
		Connection conn = DriverManager.getConnection("JDBC:mysql://localhost/rays", "root", "password");
		
		//Step 3: Create Statement object
		Statement stmt = conn.createStatement();
			
		//Step 4: Execute Query via Resultset object
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
		
		//Step 5: iterate the result in the while loop
		while(rs.next()){
			System.out.println(" ");
			System.out.print(" " + rs.getString(1));
			System.out.print(" " + rs.getString(2));
			System.out.print(" " + rs.getString(3));
			System.out.print(" " + rs.getString(4));
			System.out.print(" " + rs.getString(5));
			
		}
		
		//Step 6: Closing all objects
		stmt.close();
		rs.close();
		conn.close();
	}
}
