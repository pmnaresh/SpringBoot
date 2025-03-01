package com.test.repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Imageinput {

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		FileInputStream fis= new FileInputStream("C:\\properties\\images\\Pawan-Kalyan.jfif");
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("Insert into tollywood values(?,?)");
		pstmt.setString(1, "pawan kalyan");
		pstmt.setBlob(2, fis);
		pstmt.execute();
		System.out.println("entered into data base Successfully");
		
	}

}
