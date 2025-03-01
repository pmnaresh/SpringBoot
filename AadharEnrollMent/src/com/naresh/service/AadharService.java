package com.naresh.service;

import com.naresh.exception.AgeNotFoundException;
import com.naresh.model.Aadhar;
import com.naresh.store.AadharStore;

public class AadharService {
	AadharStore store= new AadharStore();
	
	public void createAadharService(Aadhar aadhar) throws AgeNotFoundException {
		System.out.println("aadhar entered into service layer "+aadhar.getfName());
		String gender =aadhar.getGender();
		if(gender.equalsIgnoreCase("male")) {
			aadhar.setfName("Mr."+aadhar.getfName());
		}
		else {
			aadhar.setfName("miss."+aadhar.getfName());
		}
		
		
		if(aadhar.getAge()<=0) {
			throw  new AgeNotFoundException("zero and negative numbers  are not acceptable for age ");
		}
		
		else if(aadhar.getAge()<=10) {
			aadhar.setType("kidstype");
		}
		else if(aadhar.getAge()>10 && aadhar.getAge()<=20){
			aadhar.setType("teen");
		}
		else {
			aadhar.setType("adult");
		}
		
		System.out.println("aadhar object is modifed "+aadhar.getfName());
		store.saveAadharStore(aadhar);
		
	}
	public void retriveAadharService() {
		store.retriveAadharStore();
	}
	public void updateAadharCard() {
		
	}
	public void deleteAadharCard() {
		
	}

}
