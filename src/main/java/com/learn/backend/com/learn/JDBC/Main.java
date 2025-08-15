package com.learn.backend.com.learn.JDBC;

import java.sql.*;

public class Main {

public static void main(String[] args) throws ClassNotFoundException{
	
	String urlString = "jdbc:mysql://localhost:3306/demo";
	String username ="root";
	String password = "Pass@1234";
	
	//String query = "INSERT INTO students(id,name,contact)VALUES(3,'Badekar',9756852356);"; 
	
	//String query = "DELETE FROM students WHERE id =3;";
	
	String query = "UPDATE students SET name = 'Dada', contact =9565452585 WHERE id=2;";
	
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
		
		   int rowsaffected = stmt.executeUpdate(query);
      
		 if(rowsaffected>0) {
			 System.out.println("Record Updated Successfull."+rowsaffected+"row(s) Affected");
		 }else {
			System.out.println("Insertion Failed");
		}
			
		System.out.println("=========================");
	
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
