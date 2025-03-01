package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		System.out.println("hi welcome to crud operation on student table ");
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				createStudentDetails();
				break;
			case 2:
				readStudentDetails();
				break;
			case 3:
				updateStudentDetails();
				break;
			case 4:
				deleteStudentRecord();
				break;
			default:
				System.out.println("No such choice available please selet your choice between 1 to 4");

			}

		} while (1 > 0);

	}

	public static void createStudentDetails() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Student info ");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter student Number ");
		int sno = sc.nextInt();
		System.out.println("Enter student Name");
		String sname = sc.next();
		System.out.println("enter student marks ");
		int smarks = sc.nextInt();
		// insert into student values(102,"Naresh",96)
		String createQuery = "Insert into Student values (" + sno + " ," + "'" + sname + "'" + " ," + smarks + ")";

		Connection connection = getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute(createQuery);

	}

	private static Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "system");
		return connection;
	}

	public static void readStudentDetails() throws ClassNotFoundException, SQLException {
		String readQuery = "select * from Student";

		Connection connection = getConnection();
		Statement statement = (Statement) connection.createStatement();
		ResultSet rs = ((java.sql.Statement) statement).executeQuery(readQuery);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3));
		}

	}

	public static void updateStudentDetails() throws ClassNotFoundException, SQLException {
		readStudentDetails();
		System.out.println("select record to update ");
		Scanner sc = new Scanner(System.in);
		int stdno = sc.nextInt();
		System.out.println("enter new name for student " + stdno);
		String newname = sc.next();
		System.out.println("enter a new Marks of the student " + stdno);
		int newmarks = sc.nextInt();

		// update Table_name set column_name=" " where column_id="";
		String updateQuery = "update student set sname" + "=" + "'" + newname + "'" + "where sno=" + stdno;

		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		statement.execute(updateQuery);
		readStudentDetails();
	}

	public static void deleteStudentRecord() throws ClassNotFoundException, SQLException {
		readStudentDetails();
		Scanner sc = new Scanner(System.in);
		System.out.println("select record to delete ");
		int stdno = sc.nextInt();
		// delete from table_name where sno= ;
		String deleteQuery = "delete from student where sno = " + stdno;

		Connection connection = getConnection();
		Statement statement = (Statement) connection.createStatement();
		statement.execute(deleteQuery);
	}

}
