package com.learn.backend.com.learn.JDBC;
import java.sql.*;
import java.util.Scanner;


public class PreparedStatementClass {
	
	public static void main(String[] args)throws ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Pass@1234";
		
		//String query = "Select * from students where name= ?";
		
		String query = "INSERT INTO students(id,name,contact) VALUES(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loded Successfully");
			System.out.println("======================");
		    System.out.println("");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		try {
			
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Estabilished Successfully");
			System.out.println("======================");
		    System.out.println("");
		    
		    Scanner sc = new Scanner(System.in);
		    
		    System.out.println("Enter id: ");
		    int id = sc.nextInt();
		    sc.nextLine();
		    System.out.println("Enter Name:" );
		    String name = sc.nextLine();
		    
		    System.out.println("Enter MobileNO: ");
		    long number = sc.nextLong();
		    
		    System.out.println("==========================");
		    System.out.println("");
		    
		    
		    PreparedStatement ps = con.prepareStatement(query);
		    ps.setInt(1, id);
		    ps.setString(2, name);
		    ps.setLong(3,number);
		    
		    int rSet = ps.executeUpdate();
		    
		   if(rSet>0) {
			   System.out.println("Data Inserted Succesfully");
		   }else {
			System.out.println("Some Error Occurs");
		}
		    
		    
		    
		   
		    ps.close();
		    con.close();
		    System.out.println("Connection Closed Succesfully");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	
		
		
		
	}
	

}
