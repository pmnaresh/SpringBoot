package com.example.service;

import java.util.List;

import com.example.model.InputRequest;
import com.example.model.Person;

public interface PersonService {

	 String insert(InputRequest person);
	List<Person>getPerson(String last_name);
}
