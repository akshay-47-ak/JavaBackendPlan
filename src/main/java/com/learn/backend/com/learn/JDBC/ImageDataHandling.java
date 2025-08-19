package com.learn.backend.com.learn.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class ImageDataHandling {

	public static void main(String[] args)throws ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/demo";
        String username= "root";
        String password="Pass@1234";
		
	//	String query ="INSERT INTO image_data (images) VALUES(?)";
	//	String image_path="D:\\Images\\Pu-La-Deshpande_d.jpg";
		String folderpath ="D:\\Images\\";
		String query = "SELECT images FROM image_data WHERE id = (?)";
		
        
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  System.out.println("Driver Loded Susccesfully");
			  System.out.println("=========================");
			  System.out.println("");
		  }catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		  
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established Successfully");
			System.out.println("=========================");
			System.out.println("");
			
			
			
		/***	FileInputStream fileInputStream = new FileInputStream(image_path);
			
			byte[] imageBytes = new byte[fileInputStream.available()];
			
			fileInputStream.read(imageBytes); ***/
			
			
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, 1);
			ResultSet rSet = psmt.executeQuery();
			
			if(rSet.next()) {
				
				byte[] imagedata = rSet.getBytes("images");
				String folder_Path = folderpath+"P_L_Deshpande.jpg";
				OutputStream outputStream = new FileOutputStream(folder_Path);
				outputStream.write(imagedata);
				System.out.println("Image Downloaded Successfully");
					
			}else {
				System.out.println("Data Not Found ");
			}
			
			
			
			
			/***psmt.setBytes(1, imageBytes);
			
			int affectedRows= psmt.executeUpdate();
			
			if(affectedRows>0) {
				System.out.println("Image Inserted Successfully");
				System.out.println("=========================");
			}else {
				System.out.println("Error Data Not Inseted");
				System.out.println("=========================");
			}***/
			
			
			psmt.close();
			con.close();
			System.out.println("Connection Closed Successfully");
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
