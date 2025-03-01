package com.test.multipleImages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.repository.ConnectionUtil;

public class Output {
	public static void main(String[] args) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		FileOutputStream fos = null;
		PreparedStatement pstmt = null;

		String[] strarray = new String[2];
		strarray[0] = "image1";
		strarray[1] = "image2";
		for (int i = 0; i < strarray.length; i++) {
			String filepath = "C:\\properties\\extractedimages\\" + strarray[i] + ".jfif";
			

			System.out.println(filepath + "is retriving from database");
			

			File file = new File(filepath);
			if (file.getName() != null) {
				fos = new FileOutputStream(file);
				pstmt = connection.prepareStatement("select * from tollywood ");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					
					String Name = rs.getString(1);
					Blob blob = rs.getBlob(2);

					byte[] blobinbytes = blob.getBytes(1, 20000);
					fos.write(blobinbytes);
					
				}
			} else {
				System.out.println("There is no choice which you selected");
			}
			
			
			
		}
		System.out.println("extracted succeffully from db ");
	}

}
