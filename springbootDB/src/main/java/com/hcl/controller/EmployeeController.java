package com.hcl.controller;

import java.util.List;

import com.hcl.entity.Employee;

public interface EmployeeController {
	
	List<Employee>getAll();
	
	Employee save(Employee employee);
	
	

}
