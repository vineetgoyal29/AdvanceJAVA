package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransactionHandling {
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		
		//load driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Create a database connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		conn.setAutoCommit(false);
		
		//Executing query
		PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?)");
		try{
			int id = 7;
			String fn = "Fahim";
			String ln = "Khan";
			int salary = 501;
			int did = 3;
			
			ps.setInt(1, id);
			ps.setString(2, fn);
			ps.setString(3, ln);
			ps.setInt(4, salary);
			ps.setInt(5, 3);
			
			
			//Creating int i to execute query
			int i = ps.executeUpdate();
			
			conn.commit();
		}
		catch (SQLException e) {
			conn.rollback();
		}
		
		System.out.println( " record(s) inserted ");
		
		//Closing objects
		conn.close();
		ps.close();
	}
}
