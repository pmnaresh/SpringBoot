package com.naresh.controller;

import java.util.Scanner;

import com.naresh.exception.AgeNotFoundException;
import com.naresh.model.Aadhar;
import com.naresh.model.Address;
import com.naresh.service.AadharService;

public class AadharContoller {
	static AadharService service = new AadharService();

	public static void main(String[] args) throws AgeNotFoundException {
		do {
		
		System.out.println("Choose the one of the option in the below list");
		System.out.println("1.creating the aadhar card ");
		System.out.println("2.retriving the aadhar card details ");
		System.out.println("3.updating the details of aadhar card");
		System.out.println("4.deleting the aadhar card");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		switch(choice) {
		case 1 :
			System.out.println("you are entered for  Create ");
			createAadharCard();
			break;
		case 2 :
			System.out.println("you are entered for retrival ");	
			retriveAadharCard();
			break;
		case 3:
			System.out.println("you are entered for updating ");
			updateAadharCard();
			break;
		case 4:
			System.out.println("you are entered for the deletion ");
			deleteAadharCard();
			break;
		default:
			System.out.println("your choice is not available");
			break;
		}
		
			
		}
		while(1>0);
	}
	private static void deleteAadharCard() {
		// TODO Auto-generated method stub
		
	}

	private static void updateAadharCard() {
		// TODO Auto-generated method stub
		
	}

	private static void retriveAadharCard() {
		service.retriveAadharService();
		
	}

	private  static void createAadharCard() throws AgeNotFoundException {
		Aadhar aadhar = new Aadhar();
		Address address = new Address();
		System.out.println("Enter the aadhar details");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your first name");
		aadhar.setfName(sc.next());
		System.out.println("Enter your lasr Name ");
		aadhar.setlName(sc.next());
		System.out.println("Enter your gender");
		aadhar.setGender(sc.next());
		System.out.println("enter your age ");
		aadhar.setAge(sc.nextInt());
		System.out.println("Enter your contact Number ");
		aadhar.setContactNumber(sc.nextLong());
		System.out.println("*************");
		
	System.out.println("Enter your door number ");
	address.setDoorNumber(sc.next());
	System.out.println("Enter your strret");
	address.setStreet(sc.next());
	System.out.println("enyter your city ");
	address.setCity(sc.next());
	System.out.println("Enter your State");
	address.setState(sc.next());
	System.out.println("Enter your country");
	address.setCountry(sc.next());
	System.out.println("Enter your pincode");
	address.setPin(sc.nextInt());
		
		aadhar.setAddress(address);
	System.out.println("After creating the aadhar card"+aadhar);
		service.createAadharService(aadhar);
		
		
	}

}
