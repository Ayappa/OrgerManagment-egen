package com.egen.example.egen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.egen.example.egen.models.Order;
import com.egen.example.egen.models.User;


public interface OrderRepository extends CrudRepository<Order, Integer>{
	Order save(Order order);
	Optional<Order> findById(Integer orderId);
	Order save(Optional<Order> order);
}
