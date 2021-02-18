package com.egen.example.egen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.example.egen.models.Item;
import com.egen.example.egen.repository.ItemRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	
	
	public Item saveItem (Item item) {
		System.out.println("in service");
		// TODO Auto-generated method stub
		return itemRepository.save(item);	
	}



	
}
