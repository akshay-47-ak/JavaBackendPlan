package com.learn.backend.com.learn.JDBC;

import java.io.FileNotFoundException;
import java.sql.*;

import javax.sql.rowset.spi.TransactionalWriter;

public class TanscationManagement {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String userName = "root";
		String password = "Pass@1234";
		
		String credit_query = "UPDATE bank SET balance = balance - ? WHERE acc_id = ?";
		String debit_query ="UPDATE bank SET balance = balance + ? WHERE   acc_id = ?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loded");
			System.out.println("===============================");
			System.out.println("");
		} catch (ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		
		try {
			Connection con = DriverManager.getConnection(url,userName,password);
		     con.setAutoCommit(false);
			System.out.println("Connection Estabilished");
			System.out.println("===============================");
			System.out.println("");
			
			try {
			PreparedStatement debitps = con.prepareStatement(debit_query);
			PreparedStatement creditps = con.prepareStatement(credit_query);
			
			debitps.setDouble(1, 500);
			debitps.setInt(2, 1);
			
			creditps.setDouble(1, 500);
			creditps.setInt(2, 5);
			  
		int widrowRowAffected = 	debitps.executeUpdate();
		int depositRowAffected =	creditps.executeUpdate();
		
		
		if(widrowRowAffected > 0 && depositRowAffected>0) {
			con.commit();
			System.out.println("Transaction Success");
		}else {
			con.rollback();
			System.out.println("Transactipn Failed");
		}
		
			}catch (Exception e) {
			
				
			}
			
			
			
		} catch (SQLException e) {
			
		     System.out.println(e.getMessage());
		}
		
		
		
	}
	

}
