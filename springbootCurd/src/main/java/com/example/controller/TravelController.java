package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.TravelDao;
import com.example.model.Travel;

@RestController
@RequestMapping("/travel")
public class TravelController
{
	
	@Autowired
	private  TravelDao travelDao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Travel>tickets)
	{
		travelDao.saveAll(tickets);
		return "ticket booked : " + tickets.size();
	}
	
	@GetMapping("/getTickets")
	public List<Travel>getTickets()
	{
		return (List<Travel>) travelDao.findAll();
	}

}
