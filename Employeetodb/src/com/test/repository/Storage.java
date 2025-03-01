package com.test.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.controller.Employee;

public class Storage {
	
	public void createStorage(Employee employee) {
		//insert into employee values(empid,empname,empsalary);
		
	String createQuery="insert into Employee values ("+employee.getEmpid()+ ","+"'"+employee.getEmpname()+"'"+","+employee.getSalary()+")";
	System.out.println(createQuery);
	Statement stmt=null;
	Connection connection=getConnection();
	try {
		stmt =connection.createStatement();
		stmt.execute(createQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public List<Employee> readStorage(Employee employee) {
		//select * from Employee();
		
		Statement stmt = null;
		Connection connection= getConnection();
		ArrayList<Employee> employeelist=null;
		
		try {
			employeelist=new ArrayList<Employee>();
			stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Employee");
			
			while(rs.next()) {
				 Employee emp = new Employee();
				 emp.setEmpid(rs.getInt(1));
				 emp.setEmpname(rs.getString(2));
				 emp.setSalary(rs.getInt(3));
				 employeelist.add(emp);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeelist;
	}

	private  Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM","system");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	public  Employee selectbyId(int empid) {
		Connection connection= getConnection();
		Employee emprecord=new Employee();
		try {
			Statement st =connection.createStatement();
			ResultSet rs=st.executeQuery("select * from employee where Empid ="+empid);
			while(rs.next()) {
			emprecord.setEmpid(rs.getInt(1));
			emprecord.setEmpname(rs.getString(2));
			emprecord.setSalary(rs.getInt(3));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emprecord;
		
	}
	public  String updateRecord(Employee employee) {
		boolean result = false;
		Connection connection =getConnection();
		try {
			
			Statement stmt = connection.createStatement();
			System.out.println("update employee set empname ="+"'"+employee.getEmpname()+"'"+" empsalary = "+employee.getSalary()+" where empid = "+employee.getEmpid()+";");
			
			result =stmt.execute("update Employee set empname ="+"'"+employee.getEmpname()+"'"+" empsalary = "+employee.getSalary()+" where empid = "+employee.getEmpid()+";");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result==true) {
			return"updated successfully";
		}
		else 
		return "updation failure";
		
		
	}
	

}
