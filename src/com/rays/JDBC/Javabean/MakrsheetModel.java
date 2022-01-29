package com.rays.JDBC.Javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MakrsheetModel {
	
	public static void deleteRecord(MarksheetBean bean) throws Exception {
		//Step 1: loading driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//set auto commit to false
		conn.setAutoCommit(false);
		
		//Step 3: Build query
		PreparedStatement ps = conn.prepareStatement("DELETE FROM marksheet WHERE rollno = ?");
		
		//step 4: create Marksheetbean object bean
		//Step 5: Set the value in the object
		
		ps.setInt(1, bean.getRollNo());
		
		//Step 6: execute this query
		ps.executeUpdate();
		
		//ask connection to commit the changes
		conn.commit();
		
		
		//Step 7: closing the objects
		conn.close();
		ps.close();
		
	}

	public static void updateRecord(MarksheetBean bean) throws Exception {
				//Step 1: loading driver
				Class.forName("com.rays.JDBC.Driver");
				
				//Step 2: creating connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
				
				//set auto commit to false
				conn.setAutoCommit(false);
				
				//Step 3: Build query
				PreparedStatement ps = conn.prepareStatement("UPDATE marksheet SET rollno = ?, firstname = ?, lastname = ?, physics = ?, chemistry = ?, mathematics =? WHERE id = ?");
				
				//step 4: create Marksheetbean object bean
				//Step 5: Set the value in the object
				
				ps.setInt(1, bean.getRollNo());
				ps.setString(2, bean.getFirstName());
				ps.setString(3, bean.getLastName());
				ps.setInt(4, bean.getPhysics());
				ps.setInt(5, bean.getChemistry());
				ps.setInt(6, bean.getMathematics());
				ps.setInt(7, bean.getId());
				
				//Step 6: execute this query
				ps.executeUpdate();
				
				//ask connection to commit the changes
				conn.commit();
				
				
				//Step 7: closing the objects
				conn.close();
				ps.close();
		
	}

	public static void addRecord(MarksheetBean bean) throws Exception {
		//Step 1: loading driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//set auto commit to false
		conn.setAutoCommit(false);
		
		//Step 3: Build query
		PreparedStatement ps = conn.prepareStatement("INSERT INTO marksheet VALUES (?,?,?,?,?,?,?)");
		
		//step 4: create Marksheetbean object bean
		//Step 5: Set the value in the object
		ps.setInt(1, bean.getId());
		ps.setInt(2, bean.getRollNo());
		ps.setString(3, bean.getFirstName());
		ps.setString(4, bean.getLastName());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMathematics());
		
		//Step 6: execute this query
		ps.executeUpdate();
		
		//ask connection to commit the changes
		conn.commit();
		
		
		//Step 7: closing the objects
		conn.close();
		ps.close();
		
	}
	
	public MarksheetBean getRecord(MarksheetBean bean) throws Exception {
		// Step 1: loading Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: Creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3: Build query
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM marksheet WHERE rollno = ?");
		
		//Step 4:create Marksheetbean object bean
		//Step 5: Set values in the object
		ps.setInt(1, bean.getRollNo());
		
		
		//Step 6: creating result set object rs and executing query
		ResultSet rs = ps.executeQuery();
		
		
		//Step 7: Iterate while loop
		bean = new MarksheetBean();
		
		while(rs.next()){
		bean.setId(rs.getInt(1));
		bean.setRollNo(rs.getInt(2));
		bean.setFirstName(rs.getString(3));
		bean.setLastName(rs.getString(4));
		bean.setPhysics(rs.getInt(5));
		bean.setChemistry(rs.getInt(6));
		bean.setMathematics(rs.getInt(7));
		}
		return bean;
		
		
		//Step : closing the objects
//		conn.close();
//		ps.close();
	}
	
	public List <MarksheetBean> searchSelectAll(MarksheetBean bean) throws Exception {
		// Step 1: loading Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: Creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3: Build query
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM marksheet");
		
		//Step 4:create ResultSet object
		ResultSet rs = ps.executeQuery();
		
		//Step 5: Create an arraylist 
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		//Step 6: iterate via while loop
		while(rs.next()){
			
			bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setFirstName(rs.getString(3));
			bean.setLastName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMathematics(rs.getInt(7));
			list.add(bean);
		}
		return list;
		
}

	
	public List <MarksheetBean> getMeritList(MarksheetBean bean) throws Exception {
		// Step 1: loading Driver
		Class.forName("com.rays.JDBC.Driver");
		
		//Step 2: Creating connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays", "root", "password");
		
		//Step 3: Build query
		PreparedStatement ps = conn.prepareStatement("SELECT *, "
															+ "(physics+chemistry+mathematics) AS totalMarks, "
															+ "((Physics+chemistry+mathematics)/3) AS percentage "
													+ "FROM marksheet "
													+ "WHERE (physics>40 AND chemistry>40 AND mathematics>40) "
													+ "ORDER BY percentage DESC "
													+ "LIMIT 10 ");
		
		//Step 4:create ResultSet object
		ResultSet rs = ps.executeQuery();
		
		//Step 5: Create an arraylist 
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		//Step 6: iterate via while loop
		while(rs.next()){
			
			bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getInt(2));
			bean.setFirstName(rs.getString(3));
			bean.setLastName(rs.getString(4));
			bean.setPhysics(rs.getInt(5));
			bean.setChemistry(rs.getInt(6));
			bean.setMathematics(rs.getInt(7));
		
			list.add(bean);
		}
		return list;
		
}
}


