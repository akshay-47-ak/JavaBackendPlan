package com.learn.backend.com.learn.JDBC;


import java.sql.*;
public class Test {

	public static void main(String[] args)throws ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/demo";
        String username="root";
        String password="Pass@1234";
        
        String query = "Select * From students;";
		
	 try {
		 
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Diver Loded");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	 
	   try {
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("Connected");
		
		   Statement stmt = con.createStatement();
		   
		    ResultSet rSet = stmt.executeQuery(query);
		    
		    while(rSet.next()) {
		    	
		    	int id = rSet.getInt("id");
		    	String name= rSet.getNString("name");
		    	long contact = rSet.getLong("contact");
		    	
		    	System.out.println("ID: "+id);
		    	System.out.println("Name: "+name);
		    	System.out.println("Contact: "+contact);
		    	System.out.println("");
		    	System.out.println("======================== ");
		    }
		
		    rSet.close();
		    stmt.close();
		    con.close();
		    System.out.println("Connection Closed");
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
		
	  
	
				
	}
	
	
}
