package com.egen.example.egen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egen.example.egen.models.Item;
import com.egen.example.egen.models.Order;
import com.egen.example.egen.models.Payment;
import com.egen.example.egen.service.ItemService;
import com.egen.example.egen.service.OrderService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
//	 @PostMapping("/item")
//		public  ResponseEntity<?> welcome(@RequestBody Item item) {
//	    	try {
//				Item tempItem=itemservice.saveItem(item);
//				return new ResponseEntity<>(tempItem,HttpStatus.NO_CONTENT);
//			}catch(Exception e) {
//				//log.error("Unable to delete at this time!");
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
    @PostMapping("/createorder")
    @ApiOperation(value="Create a new Order",
	notes="Provide necessary values",
	response=Order.class)
	public  ResponseEntity<?> createorder(@RequestBody Order order) {
		try {
			Order tempOrder=orderService.saveOrder(order);
			return new ResponseEntity<>(tempOrder,HttpStatus.CREATED);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PostMapping("/createBatch")
    @ApiOperation(value="Create a new batch Order",
 	notes="Provide necessary values",
 	response=Order.class)
   	public  ResponseEntity<?> createBatch(@RequestBody Iterable<Order> orderList) {
   		try {
			Iterable<Order> tempOrder=orderService.batchOrder(orderList);
			return new ResponseEntity<>(tempOrder,HttpStatus.CREATED);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   	}
    
    @GetMapping("/getOrder")
    @ApiOperation(value="Get order by Id",
 	notes="Provide necessary values",
 	response=Order.class)
    public  ResponseEntity<?> getOrder(@RequestHeader("orderId") Integer orderId) {
     	try {
			Optional<Order> tempOrder=orderService.getOderById(orderId);
			return new ResponseEntity<>(tempOrder,HttpStatus.CREATED);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PutMapping("/cancelOder")
    @ApiOperation(value="Cancel Order",
 	notes="Provide necessary values",
 	response=Order.class)
    public  ResponseEntity<?> cancelOder(@RequestHeader("orderId") Integer orderId) {
    	try {
			Order tempOrder=orderService.cancelOrder(orderId);
			return new ResponseEntity<>(tempOrder,HttpStatus.OK);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
    
    @PutMapping("/batchUpdate")
    @ApiOperation(value="Update a new Order",
 	notes="Provide necessary values",
 	response=Order.class)
    public  ResponseEntity<?> batchUpdate(@RequestHeader("status") String status,@RequestBody Iterable<Integer> ids) {
    	try {
			Iterable<Order> tempOrder=orderService.batchUpdate(ids,status);
			return new ResponseEntity<>(tempOrder,HttpStatus.OK);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PutMapping("/payment")
    @ApiOperation(value="Add  new payment",
 	notes="Provide necessary values",
 	response=Order.class)
    public  ResponseEntity<?> payment(@RequestHeader("status") Integer orderId,@RequestBody Payment payment) {
    	try {
			Order tempOrder=orderService.addPayment(payment,orderId);
			return new ResponseEntity<>(tempOrder,HttpStatus.OK);
		}catch(Exception e) {
			//log.error("Unable to delete at this time!");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    }
}
