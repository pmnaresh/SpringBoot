package com.test.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Properties properties = null;

	static {
		try {
			properties = new Properties();
			InputStream ins = new FileInputStream("C:\\properties\\dbproperties.properties");
			properties.load(ins);				
//			properties.load(ConnectionUtil.class.getClassLoader()
//					.getResourceAsStream("C:\\properties\\dbproperties.properties"));
			
			Class.forName(properties.getProperty("oracle.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					properties.getProperty("oracle.url"),
					properties.getProperty("oracle.username"),
					properties.getProperty("oracle.password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close(ResultSet resultSet, Statement statement, Connection connection) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			close(statement, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement, Connection connection) {

		try {
			if (statement != null) {
				statement.close();
			}
			close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void main(String[] args) {
		System.out.println(ConnectionUtil.getConnection());
	}
}


