package com.rays.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableFunction {
	public static void main(String[] args) throws Exception {
		// Step 1: loading Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: Creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3: Build query
		CallableStatement cs = conn.prepareCall("{?=CALL Counting_employees()}");
		
		cs.registerOutParameter(1, Types.INTEGER);
		cs.execute();
		
		
		System.out.println("Count "+ cs.getInt(1));
		
		conn.close();
		cs.close();
}
}
