package com.test.controller;

import java.util.List;
import java.util.Scanner;

import com.test.service.Service;

public class Main {
	static Service service = new Service(); 
	static Employee employee =new Employee();
	public static void main(String[] args) {
		do {
		System.out.println("welcome to employee crud operations ");
		System.out.println("1.create a employee record ");
		System.out.println("2.read employee record");
		System.out.println("3.update employee record ");
		System.out.println("4.delete employee record");
		Scanner sc= new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
		case 1 :
			createRecord();
			break;
			
		case 2:
			readRecord();
			break;
		case 3:
			updateRecord();
			break;
		case 4:
			deleteRecord();
			break;
		default:
			System.out.println("there is no  such choice please select between 1 and 4");
			
		}
		
		
	}while(1>0);
	}

	private static void deleteRecord() {
		// TODO Auto-generated method stub
		
	}

	private static void updateRecord() {
		readRecord();
		System.out.println("please select which record need to update");
		Scanner sc = new Scanner(System.in);
		int empid =sc.nextInt();
		Employee emp =service.selectbyId(empid);
		System.out.println("The below object is selected for update"+emp);
		System.out.println("Enter new name ");
		emp.setEmpname(sc.next());
		System.out.println("enter new salary ");
		emp.setSalary(sc.nextInt());
		String result = service.updateRecord(emp);
		System.out.println(result);
		
		
		
		
		
		
		
		
	}

	private static void readRecord() {
		List<Employee> emplist=service.readrecord(employee);
		for(Employee emp:emplist) {
			System.out.println(emp);
		}
		
	}

	private static void createRecord() {
		System.out.println("enter employee info to create a record ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id ");
		employee.setEmpid(sc.nextInt());
		System.out.println("enter the employee name ");
		employee.setEmpname(sc.next());
		System.out.println("enter the employee salary ");
		employee.setSalary(sc.nextInt());
		service.createRecord(employee);
		
	}

}
