package com.example.controller;

import java.util.List;

import com.example.model.InputRequest;
import com.example.model.Person;

public interface PersonController {

	
	String savePerson(InputRequest request);
	List<Person> getPerson(String lastName);
}
