package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.InputRequest;
import com.example.model.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Override
	public String insert(InputRequest request) {
         
		Person person = new Person();
		person.set("id",request.getId());
		person.set("first_name",request.getFirst_name());
		person.set("last_name",request.getLast_name());
	   boolean flag = person.insert();
	   
		return "Records inserted : "+flag;
	}

	@Override
	public List<Person> getPerson(String lastName) {
		List<Person>persons =Person.where("last_name=?", lastName);
		System.out.println(persons);
		return persons;
	}
	
	

}
