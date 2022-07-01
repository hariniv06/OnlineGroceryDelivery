package com.example.OnlineGroceryDelivery.controller;

import java.util.List;

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

import com.example.OnlineGroceryDelivery.entity.Customer;
import com.example.OnlineGroceryDelivery.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;

	public CustomerController(CustomerService customerservice) {
		super();
		// TODO Auto-generated constructor stub
	    this.customerservice =customerservice;
	}
	
	@PostMapping
	  public ResponseEntity<Customer> saveCustomer( @Valid @RequestBody Customer customer) {
 	  return new ResponseEntity<Customer>(customerservice.saveCustomer(customer),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Customer> getCustomerList()
	{
		return customerservice.getCustomerList();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id")long id) {
		return customerservice.getCustomerById(id);
		
	}
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable("id")long id ,@RequestBody Customer customer) {
		return customerservice.updateCustomer(id,customer);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id")long id ) {
		return new ResponseEntity<String>(customerservice.deleteCustomer(id),HttpStatus.OK);
	
	}
   
	@GetMapping("/GetByCustomerName/{customerName}")
	public List<Customer> getCustomerByCustomerName(@PathVariable("customerName")String customerName) {
		return customerservice.getCustomerByCustomerName(customerName);
	}
	
	@GetMapping("/GetBySurName/{surName}")
	public List<Customer> getCustomerBySurName(@PathVariable("surName")String surName) {
		return customerservice.getCustomerBySurName(surName);
	}
   
	@GetMapping("/GetByEmail/{email}")
	public List<Customer> getCustomerByEmail(@PathVariable("email")String email) {
		return customerservice.getCustomerByEmail(email);
}

	@GetMapping("/GetByAadharNumber/{aadharNumber}")
	public Customer getCustomerByAadharNumber(@PathVariable("aadharNumber")long aadharNumber) {
		return  customerservice.getCustomerByAadharNumber(aadharNumber);
} 
	
}	