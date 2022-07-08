package com.example.OnlineGroceryDelivery.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineGroceryDelivery.entity.Order;
import com.example.OnlineGroceryDelivery.service.OrderService;

@RestController
@RequestMapping("/api/order")

public class OrderController {

	@Autowired
	OrderService orderservice;

	public OrderController(OrderService orderservice) {
		super();
		// TODO Auto-generated constructor stub
		this.orderservice =orderservice;
	}
	
	@PostMapping
	  public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order order) {
	  return new ResponseEntity<Order>(orderservice.saveOrder(order),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Order> getOrderList()
	{
		return orderservice.getOrderList();
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable("id")long id) {
		return orderservice.getOrderById(id);
		
	}
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable("id")long id ,@Valid @RequestBody Order order) {
		return orderservice.updateOrder(id,order);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id")long id ) {
		return new ResponseEntity<String>(orderservice.deleteOrder(id),HttpStatus.OK);
		
	}
	@GetMapping("/GetByOrderTrackingNumber/{orderTrackingNumber}")
	public Order getOrderByOrderTrackingNumber(@PathVariable("orderTrackingNumber")String orderTrackingNumber) {
		return orderservice.getOrderByOrderTrackingNumber(orderTrackingNumber);
		
	}
	
	@GetMapping("/GetByOverallTotal/{overallTotal}")
	public List <Order> getOrderByOverallTotal(@PathVariable("overallTotal")String overallTotal) {
		return orderservice.getOrderByOverallTotal(overallTotal);
		
	}
	
	@GetMapping("/GetByProductCount/{productCount}")
	public Order getOrderByProductCount(@PathVariable("productCount")long productCount) {
		return orderservice.getOrderByProductCount(productCount);
		
	}
	
	@GetMapping("/GetByStatus/{status}")
	public List <Order> getOrderByStatus(@PathVariable("status")String status) {
		return orderservice.getOrderByStatus(status);
		
}
	@GetMapping("/GetOrderGroupByStatus")
	public ResponseEntity<Map<Object , Object>> getOrderGroupByStatus() {
		return new ResponseEntity<Map<Object , Object>>(orderservice.getOrderGroupByStatus(), HttpStatus.OK);
	}
	}

