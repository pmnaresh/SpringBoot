package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.InputRequest;
import com.example.model.Person;
import com.example.service.PersonServiceImpl;

@RestController
@RequestMapping("/request")
public class PersonControllerImpl implements PersonController {

	@Autowired
	PersonServiceImpl service;
	@Override
	@PostMapping("/savePerson")
	public String savePerson(@RequestBody InputRequest request) {
		
		return service.insert(request);
	}

	@Override
	@GetMapping("/getPerson/{lastName}")
	public List<Person> getPerson(@PathVariable String lastName) {
		
		return service.getPerson(lastName);
	}

}
