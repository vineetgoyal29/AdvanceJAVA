package com.rays.JDBC;

import java.awt.Window.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CallableChecking {
	public static void main(String[] args) throws Exception {
				// Step 1: loading Driver
				Class.forName("com.rays.JDBC.Driver");
				
				//Step 2: Creating connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
				//Step 3: Build query
				CallableStatement cs = conn.prepareCall("{CALL Emp_count(?)}");
				
				cs.registerOutParameter(1, Types.INTEGER);
				cs.execute();
				
				int count = cs.getInt(1);
				System.out.println("Count "+ count);
				
				conn.close();
				cs.close();
	}
}
