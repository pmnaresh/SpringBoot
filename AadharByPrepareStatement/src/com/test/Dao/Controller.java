package com.test.Dao;

import java.util.List;
import java.util.Scanner;

import com.test.Service.Service;

public class Controller {
	private static final Object gender = null;
	static Service service = new Service();
	static Aadhar aadhar = new Aadhar();

	public static void main(String[] args) {

		do {
			System.out.println("welcome to Aadhar Registration Form ");
			System.out.println("1.create Aadhar record ");
			System.out.println("2.read Aadhar record");
			System.out.println("3.update Aadhar record ");
			System.out.println("4.delete Aadhar record");
			System.out.println("5.male Aadhar record");
			System.out.println("6.for same district record");
			System.out.println("7.for same State record");
			System.out.println("8.for same country record ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				createAadharRecord();
				break;
			case 2:
				readAadharRecord();
				break;
			case 3:
				updateAadharRecord();
				break;
			case 4:
				deleteAadharRecord();
				break;
			case 5:
				maleAadharRecords();
				break;
			case 6:
				fromSameDistrict();
				break;
			case 7:
				forSameState();
				break;
			case 8:
				forSameCountry();
				break;
			default:
				System.out.println("there is no  such choice please select between 1 and 8");

			}

		} while (1 > 0);
	}

	private static void forSameCountry() {
		System.out.println("choose the country name");
		Scanner sc = new Scanner(System.in);
		String country = sc.next();
		List<String> list=service.fromSameCountry(country);
		System.out.println(list);
	}

	private static void forSameState() {
		System.out.println("choose the state name");
		Scanner sc = new Scanner(System.in);
		String state = sc.next();
		List<String> list=service.fromSameState(state);
		System.out.println(list);
	}

	private static void fromSameDistrict() {
		System.out.println("choose the district name");
		Scanner sc = new Scanner(System.in);
		String district = sc.next();
		List<String> list=service.fromSameDistrict(district);
		System.out.println(list);
		
	}

	private static void maleAadharRecords() {
		System.out.println("choose the gender");
		Scanner sc = new Scanner(System.in);
		String gender = sc.next();
		List<String> list = service.maleAadharRecord(gender);
		System.out.println(list);
	}

	private static void deleteAadharRecord() {
		readAadharRecord();
		System.out.println("choose the serial number to delete ");
		Scanner sc = new Scanner(System.in);
		int sno = sc.nextInt();
		service.deleteAadharRecord(sno);
		readAadharRecord();

	}

	private static void updateAadharRecord() {
		readAadharRecord();
		System.out.println("choose the serial number to update ");
		Scanner sc = new Scanner(System.in);
		int sno = sc.nextInt();

		Aadhar aadharlist = service.selectBySerialNumber(sno);

		System.out.println("please change the details for which record you are choose above " + sno);
		System.out.println("selectd record " + aadharlist);
		System.out.println("Enter the new  First Name ");
		aadharlist.setFirstName(sc.next());
		System.out.println("Enter the LastName");
		aadharlist.setLastName(sc.next());
		System.out.println("Enter the Fathers Name ");
		aadharlist.setFathersName(sc.next());
		System.out.println("Enter the gender ");
		aadharlist.setGender(sc.next());
		System.out.println("enter your age");
		aadharlist.setAge(sc.nextInt());
		System.out.println("enter your contact Number ");
		aadharlist.setContactNumber(sc.nextLong());
		System.out.println("enter your village Name");
		aadharlist.setVillage(sc.next());
		System.out.println("enter your district ");
		aadharlist.setDistrict(sc.next());
		System.out.println("Enter your State ");
		aadharlist.setState(sc.next());
		System.out.println("Enter your Country ");
		aadharlist.setCountry(sc.next());
		System.out.println("Enter your pincode ");
		aadharlist.setPincode(sc.next());
		System.out.println("Enter your income per month ");
		aadharlist.setIncome(sc.nextInt());

		String str = service.updateAadharRecord(aadharlist);
		readAadharRecord();
	}

	private static void readAadharRecord() {

		List<Aadhar> list = service.readAadharRecord(aadhar);
		for (Aadhar aadhar : list) {
			System.out.println(aadhar);

		}

	}

	private static void createAadharRecord() {

		System.out.println("Hi please provide the follwing details ...");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter  your serial number ");
		aadhar.setSerialNumber(sc.nextInt());

		System.out.println("Enter your first name ");
		aadhar.setFirstName(sc.next());
		System.out.println("Enter your last Name ");
		aadhar.setLastName(sc.next());
		System.out.println("Enter your fathers Name");
		aadhar.setFathersName(sc.next());
		System.out.println("Enter your gender");
		aadhar.setGender(sc.next());
		System.out.println("Enter your age ");
		aadhar.setAge(sc.nextInt());
		System.out.println("enter your contact Number ");
		aadhar.setContactNumber(sc.nextLong());
		System.out.println("enter your village Name");
		aadhar.setVillage(sc.next());
		System.out.println("enter your district ");
		aadhar.setDistrict(sc.next());
		System.out.println("Enter your State ");
		aadhar.setState(sc.next());
		System.out.println("Enter your Country ");
		aadhar.setCountry(sc.next());
		System.out.println("Enter your pincode ");
		aadhar.setPincode(sc.next());
		System.out.println("Enter your income per month ");
		aadhar.setIncome(sc.nextInt());

		service.createAadharRecord(aadhar);

	}

}
