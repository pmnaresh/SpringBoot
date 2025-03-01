package com.hcl.spring.sheduler.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.spring.sheduler.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
