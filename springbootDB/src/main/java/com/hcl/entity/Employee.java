package com.hcl.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee5")
public class Employee {

	@EmbeddedId
	private EmployeePKId employeePKId;
	
	private String name;
	private String email;
	private String phone;
	
	
	public EmployeePKId getEmployeePKId() {
		return employeePKId;
	}
	public void setEmployeePKId(EmployeePKId employeePKId) {
		this.employeePKId = employeePKId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Employee() {
		super();
		
	}
	public Employee( EmployeePKId employeePKId,String name, String email, String phone) {
		super();
		this.employeePKId= employeePKId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Employee [ EmployeePKId =" +employeePKId+",name=" + name + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
	
}
