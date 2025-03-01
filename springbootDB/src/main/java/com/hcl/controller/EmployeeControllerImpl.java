package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.entity.Employee;
import com.hcl.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeRepository emprepo;
	
	@Override
	@GetMapping("/emp")
	public List<Employee> getAll() {
		
		return emprepo.findAll();
	}
	@Override
	@PostMapping("/slt")
	public Employee save(@RequestBody Employee employee) {
		
		return emprepo.save(employee);
	}
	
	
	}
	
	
	
	
	

