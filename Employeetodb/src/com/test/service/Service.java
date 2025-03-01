package com.test.service;

import java.util.List;

import com.test.controller.Employee;
import com.test.repository.Storage;

public class Service {
	Storage storage= new Storage();
	
	public void createRecord(Employee employee) {
		storage.createStorage(employee);	
	}
	public List<Employee> readrecord(Employee employee) {
		List<Employee> emplist = storage.readStorage(employee);
		return emplist;
	}
	public Employee selectbyId(int empid) {
		Employee emp =storage.selectbyId(empid);
		return emp;
		
	}
	public String  updateRecord(Employee employee) {
		String result =storage.updateRecord(employee);
		return result;
		
	}
	

}
