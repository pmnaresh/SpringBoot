package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BookTicket")
public class Travel 
{
	
	@Id
	@GeneratedValue
	
	private int seat_no;
	private String name;
	private String your_city;
	private String destination_city;
	public int getSet_no() {
		return seat_no;
	}
	public void setSet_no(int set_no) {
		this.seat_no = set_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYour_city() {
		return your_city;
	}
	public void setYour_city(String your_city) {
		this.your_city = your_city;
	}
	public String getDestination_city() {
		return destination_city;
	}
	
	public void setDestination_city(String destination_city) {
		this.destination_city = destination_city;
	}
	
	public Travel() {
		super();
		
	}
	public Travel(int seat_no, String name, String your_city, String destination_city) {
		super();
		this.seat_no = seat_no;
		this.name = name;
		this.your_city = your_city;
		this.destination_city = destination_city;
	}
	@Override
	public String toString() {
		return "Travel [set_no=" + seat_no + ", name=" + name + ", your_city=" + your_city + ", destination_city="
				+ destination_city + "]";
	}
	
	

}
