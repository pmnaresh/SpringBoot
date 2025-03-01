package com.test;

public class Employee {
	private int id;
	private String employeename;
	private int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeename=" + employeename + ", salary=" + salary + "]";
	}
	public void methodone() {
		System.out.println("Hi " +employeename+" your id number is "+id +" and your monthly salary is "+salary);
		
	}
	

}
