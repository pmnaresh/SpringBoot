package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.entity.Employee;
import com.hcl.entity.EmployeePKId;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,EmployeePKId> {

	
	
}
