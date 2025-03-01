package com.test;

public class Student {
	private String name;
	private int id;
	private int salary;

	public Student(String name, int id, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}
public void display() {
	System.out.println("Hi "+name +" your id is "+id +" and your salary is "+salary);
}
}
