package com.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

	public class TestCrudUsingPrepared {
	
		public static void main(String[] args) throws Exception {
			displaytable();
			testadd();
			testupdate();
			testdelete();
			displaytable();
	}
//1>
		public static void testdelete() throws Exception {
	
			// Step 1: Loading MySQL database Driver
			 	Class.forName("com.mysql.jdbc.Driver");
			
			// Step 2: Creating a connection to the database via conn object of connection Interface	
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","password");
				
			// creating local variable id
				int id=5;
				
			// Step 3: Executing query via the ps object of PreparedStatement Interface 
				PreparedStatement ps = conn.prepareStatement("DELETE  FROM EMPLOYEE WHERE ID=?" );
				ps.setInt(1, id);
			
			// creating a local variable i
				int i = ps.executeUpdate();
			
			// Display the success message of query
				System.out.println(i + "One row deleted");
				
				
			// Step 4: Closing the objects to avoid memory leakages
				ps.close();
				conn.close();
				}

//2>
		public static void testupdate() throws  Exception {
		
			//Step 1: Loading MySQL Database Driver
		        Class.forName("com.mysql.jdbc.Driver");
				
		    //Step 2: Creating a connection to the database(rays)
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","password");
				
			//Setting up local variables
				int id = 12300;
				String fname = "Ritesh";
				String lname = "Sharma";
				int salary = 16000;
				int dept_Id  = 4;
			
			//Step 3: Executing Query via the PreparedStatement Interface
		        PreparedStatement ps =  (PreparedStatement) conn.prepareStatement("UPDATE EMPLOYEE Set FIRSTNAME=?,LASTNAME=?,SALARY=?, dept_Id=? WHERE ID=?");
				
		        ps.setString(1, fname);
		        ps.setString(2, lname);
		        ps.setInt(3, salary);
		        ps.setInt(4, dept_Id);
		        ps.setInt(5, id);
	    
		    //Creating a local variable int i to execute query   
		       int  i =  ps.executeUpdate();
		       
		    //Display the success of the query
		        System.out.println(" ");
		        System.out.println(" ");
		        System.out.println(i + "updated");
		        
		        
		    //Step 4: closing all objects to avoid memory leakages
		        ps.close();
		        conn.close();
			
		}

//3>	
		public static void testadd() throws Exception {
	
			
				// Step 1: Loading the MySQL Database Driver
			        Class.forName("com.mysql.jdbc.Driver");
					
			   // Step 2: Creating a connection via the conn object of Connection Interface
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/rays","root","password");
			   
			   // creating the local variables
					int id = 123000;
					String fname = "Rahul";
					String lname = "Joshi";
					int Salary = 17000;
					int depId = 3;
			   
			   // Step 3: Creating the ps object of PreparedStatement Interface 
			   //		  And writing the query in ps object	
					PreparedStatement ps = conn.prepareStatement(" insert into employee value (?,?,?,?,?)" );
					
					ps.setInt(1, id);
					ps.setString(2, fname);
					ps.setString(3, lname);
					ps.setInt(4, Salary);
					ps.setInt(5, depId);
					
			   // Creating a local variable int i
					int i = ps.executeUpdate();
					
			  // Displaying the success of the query
					System.out.println(" ");
					System.out.println(" ");
					System.out.println(i + "ONE ROW INSERTED"); 
					
			  // Step 4: Closing all the objects to avoid memory leakages
					conn.close();
					ps.close();
			
		}
//4>
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
				
				
		   // Step 4: Closing all the objects to avoid memory leakages
		        ps.close();
		        conn.close();
		}
	}
