package com.egen.example.egen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.egen.example.egen.models.Item;
import com.egen.example.egen.service.ItemService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api")
@Log4j2

public class ItemController {
	@Autowired
	ItemService itemservice;
	
    @PostMapping("/item")
    @ApiOperation(value="Create a new item",
	notes="Provide necessary values",
	response=Item.class)
	public  ResponseEntity<?> welcome(@RequestBody Item item) {
    	try {
			Item tempItem=itemservice.saveItem(item);
			return new ResponseEntity<>(tempItem,HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
