package com.naresh.model;

public class Address {
	private String doorNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private Integer pin;
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pin=" + pin + "]";
	}
	

}
