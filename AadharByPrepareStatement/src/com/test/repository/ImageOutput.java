package com.test.repository;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageOutput {

	public static void main(String[] args) throws SQLException, IOException {
		Connection connection =ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from tollywood ");
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
			String Name = rs.getString(1);
			Blob blob=rs.getBlob(2);
			FileOutputStream fos = new FileOutputStream("C:\\properties\\extractedimages\\pawan.jfif");
			byte[] blobinbytes=blob.getBytes(1, 20000);
			fos.write(blobinbytes);
			System.out.println("extracted succeffully from db ");
			
		}
		
		

	}

}
