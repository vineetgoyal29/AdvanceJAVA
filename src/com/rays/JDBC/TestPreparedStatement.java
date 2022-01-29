package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatement {
	public static void main(String[] args) throws Exception {
		displayTable();
//		insertRecord();
//		displayTable();
	}

	public static void insertRecord() throws Exception {
		// Step 1: load MySQL database Driver
		Class.forName("com.rays.JDBC.Driver");
				
		//Step 2: Create a connection to database via conn object of Connection class
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
		int id = 420;
		String fn = "ramlal";
		String ln = "SonofShjadf";
		int sal = 420420;
		int did = 3;
		
		//Step 3: Create preparestmt object of PreparedStatement class
		PreparedStatement preparestmt = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?)");
		
		preparestmt.setInt(1, id);
		preparestmt.setString(2, fn);
		preparestmt.setString(3, ln);
		preparestmt.setInt(4, sal);
		preparestmt.setInt(5, did);
		
		//Step 4: create an i object of int to execute this query
		int i = preparestmt.executeUpdate();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(i + " Record(s) updated");
		System.out.println(" ");
	}

	public static void displayTable() throws Exception {
		// Step 1: load MySQL database Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: Create a connection to database via conn object of Connection class
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3: Create preparestmt object of PreparedStatement class
		PreparedStatement preparestmt = conn.prepareStatement("SELECT * FROM employee");
		
		//Step 4: process result via the rs object of ResultSet class
		ResultSet rs = preparestmt.executeQuery();
		
		//Step 5: iterate the result using while loop
		while(rs.next()){
			System.out.println(" ");
			System.out.print(rs.getString(1));
			System.out.print("       "+rs.getString(2));
			System.out.print("       "+rs.getString(3));
			System.out.print("       "+rs.getString(4));
			System.out.print("       "+rs.getString(5));
		}
		
	}
}
