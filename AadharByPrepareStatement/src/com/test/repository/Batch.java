package com.test.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch {

	public static void main(String[] args) throws SQLException {
		String insertQuery1 = "inset into fruits values(1,'Mango',90,2)";
		String insertQuery2="Insert into fruits values (2,'Orange',50,3)";
		String insertQuery3="Insert into fruits values (3,'Banana',20,1)";
		String insertQuery4="Insert into fruits values (4,'sapota',60,12)";
		String insertQuery5="Insert into fruits values (5,'Apple',250,20)";
		String insertQuery6="Insert into fruits values (6,'promagranate',125,6)";

		String updateQuery1="update fruits set name='straberry' where sno =3";
		System.out.println(updateQuery1);
		String updateQuery2="update fruits set name='grapes' where sno =3";
		System.out.println(updateQuery2);
		
		String deleteQuery="delete from fruits where sno =3";
		
		Connection connection= ConnectionUtil.getConnection();
		Statement stmt=connection.createStatement();
		stmt.addBatch(insertQuery1);
		stmt.addBatch(insertQuery2);
		stmt.addBatch(insertQuery3);
		stmt.addBatch(insertQuery4);
		stmt.addBatch(insertQuery5);
		stmt.addBatch(updateQuery1);
		stmt.addBatch(updateQuery2);
		stmt.addBatch(deleteQuery);
		
		
		
	}

}
