package com.egen.example.egen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egen.example.egen.models.Item;
import com.egen.example.egen.models.User;

import lombok.extern.log4j.Log4j2;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item save(Item item);
}
