package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Travel;

@Repository
public interface TravelDao extends CrudRepository<Travel,Integer>
{
	

}
