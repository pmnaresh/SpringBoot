package com.test.Service;

import java.util.List;

import com.test.Dao.Aadhar;
import com.test.repository.Storage;

public class Service {
	Storage storage = new Storage();

	public void createAadharRecord(Aadhar aadhar) {
		storage.createAdharRecord(aadhar);

	}

	public List<Aadhar> readAadharRecord(Aadhar aadhar) {
		List<Aadhar> list = storage.readAadharRecord(aadhar);
		return list;

	}

	public Aadhar selectBySerialNumber(int sno) {
		Aadhar aadhar = storage.selectBySerialNumber(sno);
		return aadhar;
	}

	public void deleteAadharRecord(int sno) {
		storage.deleteAadharRecord(sno);

	}

	public String updateAadharRecord(Aadhar aadharlist) {
		String str = storage.updateAadharRecord(aadharlist);
		return str;
	}

	public List<String> maleAadharRecord(String gender) {
		return storage.maleAadharRecord(gender);

	}

	public List<String> fromSameDistrict(String district) {
		return storage.fromSameDistrict(district);
		
	}

	

	public List<String> fromSameState(String state) {
		return storage.fromSameState(state);
	}

	public List<String> fromSameCountry(String country) {
		return storage.fromSameCountry(country);
	}

}
