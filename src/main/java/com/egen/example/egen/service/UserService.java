package com.egen.example.egen.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.egen.example.egen.models.User;
import com.egen.example.egen.repository.UserRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2

@Service
public class UserService implements UserDetailsService  {
	@Autowired
	private UserRepository userRepository;
	
	
	
	public User saveUser(User user) {
		System.out.println("in service");
		// TODO Auto-generated method stub
		return userRepository.save(user);	
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(username);
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}



	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
}
