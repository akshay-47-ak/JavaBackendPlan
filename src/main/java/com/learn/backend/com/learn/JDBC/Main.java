package com.learn.backend.com.learn.JDBC;

import java.sql.*;

public class Main {

public static void main(String[] args) throws ClassNotFoundException{
	
	String urlString = "jdbc:mysql://localhost:3306/demo";
	String username ="root";
	String password = "Pass@1234";
	
	String query = "Select * from students;";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Class Loded");
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
		
	}
	System.out.println("=========================");
	try {
		Connection conn = DriverManager.getConnection(urlString,username,password);
		System.out.println("Database Connected Successfully");
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);

		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			long contact = rs.getLong("contact");
			
			System.out.println("=========================");
			
			System.out.println("ID: "+id);
			System.out.println("Name: "+name);
			System.out.println("Contact: "+contact);
			
		}
		
		
		System.out.println("=========================");
		rs.close();
		stmt.close();
		conn.close();
		System.out.println();
		System.out.println("Connection Clossed Successfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	
	
}
	
	
}
