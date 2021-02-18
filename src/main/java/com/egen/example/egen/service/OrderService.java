package com.egen.example.egen.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egen.example.egen.models.Order;
import com.egen.example.egen.models.Payment;
import com.egen.example.egen.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;
@Log4j2

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Order saveOrder(Order order) {
		System.out.println("in service");
		// TODO Auto-generated method stub
		return orderRepository.save(order);	
	}

	public Optional<Order> getOderById(Integer orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}

	public Order cancelOrder(Integer orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order=orderRepository.findById(orderId);
	
		Order temp=order.get();
		temp.setStatus("canceled");
		temp.getPayment().setPaymentStatus("refunded");
		System.out.println("at cancelOrder---->>"+order.toString()+" ----");
		return orderRepository.save(temp);
	}
	
	public Iterable<Order> batchOrder(Iterable<Order> orderList) {
		// TODO Auto-generated method stub
		return orderRepository.saveAll(orderList);
	}

	@Transactional
	public Iterable<Order> batchUpdate(Iterable<Integer> ids,String status) {
		Iterable<Order> ordersList =orderRepository.findAllById(ids);
		 for (Order or : ordersList) {
			 if(status.contentEquals("canceled")) {
				 or.setStatus(status);
				 or.getPayment().setPaymentStatus("refunded");
			 }else {
				 or.setStatus(status);
			 }
	        }
		return ordersList;
	}

	public Order addPayment(Payment payment,Integer orderId) {
		// TODO Auto-generated method stub
		Optional<Order> order=orderRepository.findById(orderId);
		Order temp=order.get();
		temp.setPayment(payment);
		return orderRepository.save(temp);
	}
  
}
