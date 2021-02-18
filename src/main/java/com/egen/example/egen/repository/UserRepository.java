package com.egen.example.egen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.egen.example.egen.models.User;

import lombok.extern.log4j.Log4j2;


public interface UserRepository  extends JpaRepository<User, Integer>{
	User save(User user);

	User findByEmail(String username);

}
