package com.test.multipleImages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.repository.ConnectionUtil;

public class Input {

	public static void main(String[] args) throws IOException, Exception {
		FileInputStream fis=null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt=null;
		// TODO Auto-generated method stub
		String[] strarray=new String[2];
		strarray[0]="image1";
		strarray[1]="image2";
//		strarray[2]="image3";
		for(int i=0;i<strarray.length;i++) {
			String filepath="C:\\properties\\images\\"+strarray[i]+".jfif";
			
			System.out.println(filepath+"is uplodig to database");
			File file = new File(filepath);
			if(file.getName()!=null) {
				fis=new FileInputStream(file);
			}
			else {
				System.out.println("There is no choice which you selected");
				
			}
			pstmt = connection.prepareStatement("Insert into tollywood values(?,?)");
			pstmt.setString(1, file.getName());
			pstmt.setBlob(2, fis);
			pstmt.execute();
			System.out.println("entered into data base Successfully");
		}
	
		
		
		
	}

}
