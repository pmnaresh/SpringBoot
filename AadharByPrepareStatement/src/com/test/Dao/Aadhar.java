package com.test.Dao;

public class Aadhar {
	private int serialNumber;
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	private String firstName;
	private String lastName;
	private String fathersName;
	private String gender;
	private int age;
	private long contactNumber;
	private String village ;
	private String district;
	private String state;
	private String country;
	private String pincode;
	private int income;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	@Override
	public String toString() {
		return "Aadhar [serialNumber=" + serialNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fathersName=" + fathersName + ", gender=" + gender + ", age=" + age + ", contactNumber="
				+ contactNumber + ", village=" + village + ", district=" + district + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + ", income=" + income + "]";
	}
	
	
	
	
	

}
