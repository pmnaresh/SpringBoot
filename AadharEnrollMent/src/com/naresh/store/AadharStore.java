package com.naresh.store;

import java.util.ArrayList;

import com.naresh.model.Aadhar;

public class AadharStore {
	ArrayList<Aadhar> list= new ArrayList<Aadhar>();
	public void saveAadharStore(Aadhar aadhar) {
		
		list.add(aadhar);
		System.out.println(list);
	}
	public void retriveAadharStore() {
		System.out.println(list);
		
	}
	public void updateAadharStore() {
		
	}
	public void deleteAadharStrore() {
		
	}
}
