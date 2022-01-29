package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMultipleAddByPreparedStatement {
	public static void main(String[] args) throws Exception {
		displaytable();
		addRecords();
		displaytable();
		
	}
	
	private static void addRecords() throws Exception {
		int id = 18;
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
		
		//Adding second record
			
			int id_2 = 19;
			String fn_2 = "Virendra";
			String ln_2 = "Shewag";
			int sal_2 = 18000;
			int dId_2 = 7;
		
			PreparedStatement ps_2 = conn.prepareStatement("INSERT INTO employee values (?,?,?,?,?)");
			
			ps.setInt(1, id_2);
			ps.setString(2, fn_2);
			ps.setString(3, ln_2);
			ps.setInt(4, sal_2);
			ps.setInt(5, dId_2);
		
		// Step 4: closing objects
		conn.close();
		ps.close();
}

	public static void displaytable() throws Exception {
		
		
		// Step 1: Loading the MySQL Database Driver
			Class.forName("com.mysql.jdbc.Driver");
			
	   // Step 2: Creating a connection via the conn object of Connection Interface	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","password");
			
	   // Step 3: Creating the ps object of PreparedStatement Interface 
	   //		 And writing the query in ps object		
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Employee");
			
	   // Executing the Query
			ResultSet i = ps.executeQuery();
			
	   // Displaying the RESULT of the query
			while (i.next()) {
				System.out.println(" ");
				System.out.print(" "+ i.getString(1));
				System.out.print(" "+ i.getString(2));
				System.out.print(" "+ i.getString(3));
				System.out.print(" "+ i.getString(4));
				System.out.print(" "+ i.getString(5));
		    }

	}
}
