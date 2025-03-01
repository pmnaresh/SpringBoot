package com.hcl.spring.sheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.spring.sheduler.dao.UserDao;
import com.hcl.spring.sheduler.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	Logger log = LoggerFactory.getLogger(UserService.class);
	
	//schedule a job to add object in DB (every 5 sec)
	@Scheduled(fixedRate = 5000)
	public void addJob()
	{
		User user = new User();
		user.setName("user"+new Random().nextInt(3678));
		userDao.save(user);
		System.out.println("add service call in "+new Date().toString());
	}
	@Scheduled(cron="0/15 * * * * *")
	public void fetchJob()
	{
		List<User>users = userDao.findAll();
		System.out.println("fetch service call in"+new Date().toString());
		System.out.println("no of records fected"+users.size());
		log.info("users : {}",users);
	}
}
