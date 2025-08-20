package com.learn.backend.com.learn.JDBC;

import java.sql.*;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/demo";
		String username = "root";
		String password = "Pass@1234";

		

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Diver Loded");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
           System.out.println("================================");
			
           String query = "INSERT INTO students(id , name , contact) VALUES(?,?,?)";
           
           PreparedStatement ps = con.prepareStatement(query);
			Scanner sc  = new Scanner(System.in);
           
			
           
             while(true) {
            	 System.out.println("Enter Id: ");
            	 int id = sc.nextInt();
            	 sc.nextLine();
            	 System.out.println("Enter Name: ");
            	 String name = sc.nextLine();
            	 System.out.println("Enter MobileNo: ");
            	 Long contact = sc.nextLong();
            	 
            	 ps.setInt(1, id);
            	 ps.setString(2, name);
            	 ps.setLong(3, contact);

            	 ps.addBatch();
            	 sc.nextLine();            	 System.out.println("Add more Values Y/N");
            	 String decision = sc.nextLine();
            	 if(decision.toUpperCase().equals("N")) {
            		 break;
            	 }
            	 
             }
             
             
			int[] batchResult = ps.executeBatch();
			System.out.println("Batch Executed Succesfully");
			
			
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
