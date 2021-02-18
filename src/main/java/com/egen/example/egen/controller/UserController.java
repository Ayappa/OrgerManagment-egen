package com.egen.example.egen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.example.egen.jwt.JwtBean;
import com.egen.example.egen.jwt.JwtUtil;
import com.egen.example.egen.models.Order;
import com.egen.example.egen.models.User;
import com.egen.example.egen.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userservice;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManagerBean;
	@Autowired 
	private JwtUtil jwt;
	
    @PostMapping("/user")
	public User welcome(@RequestBody User user) {
    	System.out.println(user.toString());
		return userservice.saveUser(user);
	}
    
    @PostMapping("/registerUser")
    @ApiOperation(value="Register a new user",
 	notes="Provide necessary values",
 	response=JwtBean.class)
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
			User userCheck=userservice.findUserByEmail(user.getEmail());
			if(userCheck!=null) {
				final JwtBean jwtToken=new JwtBean("alreadyExists");
				return new ResponseEntity<>(jwtToken,HttpStatus.NO_CONTENT);
			}
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User userDetails= userservice.saveUser(user);
			String toekn=jwt.generateToken(userDetails);
			final JwtBean jwtToken=new JwtBean(toekn);
				return new ResponseEntity<>(jwtToken,HttpStatus.CREATED);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PostMapping("/loginUser")
    @ApiOperation(value="Login user",
 	notes="Provide necessary values",
 	response=JwtBean.class)
	public ResponseEntity<?>  loginUser(@RequestBody User user) throws Exception {
    	try {
			User userCheck=userservice.findUserByEmail(user.getEmail());
			if(userCheck==null) {
				final JwtBean jwtToken=new JwtBean("user dont exists");
				return new ResponseEntity<>(jwtToken,HttpStatus.NO_CONTENT);
			}
			System.out.println("in check request ="+ user.toString() );
			try {
			authenticationManagerBean.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
			}
			catch(BadCredentialsException e) {
				final JwtBean jwtToken=new JwtBean("Incorrect creditional");
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				//throw new Exception("Incorrect creditional",e);
			}
			User userDetails=userservice.findUserByEmail(user.getEmail());
			String toekn=jwt.generateToken(userDetails);
			final JwtBean jwtToken=new JwtBean(toekn);
			return new ResponseEntity<>(jwtToken,HttpStatus.CREATED);
    	}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
