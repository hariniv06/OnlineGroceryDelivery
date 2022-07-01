package com.example.OnlineGroceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.OnlineGroceryDelivery.entity.Customer;
import com.example.OnlineGroceryDelivery.exception.AadharNumberNotMatchedException;
import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.ResourceNotFoundException;
import com.example.OnlineGroceryDelivery.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerrepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerrepository) {
		super();
		// TODO Auto-generated constructor stub
		this.customerrepository = customerrepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerrepository.save(customer);
	}
	

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		List<Customer> customers =customerrepository.findAll();
		
		if (customers.isEmpty()) {
			throw new NoRecordFoundException();
			
		}
		
				else {
					return customers;
					
	}
	}

	

	@Override
	public Customer getCustomerById(long id) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerrepository.findById(id);
		if (customer.isPresent()) {
		return customer.get();
	}
		else {
			throw new GivenIdNotFoundException();

	}
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) {
		// TODO Auto-generated method stub
		Customer cust=new Customer();
		cust=customerrepository.findById(id).orElseThrow(
		()-> new ResourceNotFoundException("Customer","Id",id));
		
		cust.setCustomerName(customer.getCustomerName());
		cust.setSurName(customer.getSurName());
		cust.setEmail(customer.getEmail());
		cust.setAadharNumber(customer.getAadharNumber());
		cust.setContactNo(customer.getContactNo());
		
		customerrepository.save(cust);
		return cust;
	}

	@Override
	public String deleteCustomer(long id) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		customer =customerrepository.findById(id).orElseThrow(
		()-> new ResourceNotFoundException("Customer","Id",id));
		
		customerrepository.deleteById(id);
		return "Record is deleted successfully";
	}
	@Override
	public List<Customer> getCustomerByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByCustomerName(customerName);
	}

	@Override
	public List<Customer> getCustomerBySurName(String surName) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerBySurName(surName);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerrepository.getCustomerByEmail(email);
	}

	@Override
	public Customer getCustomerByAadharNumber(long aadharNumber) {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerrepository.findByAadharNumber(aadharNumber);
		if(customer.isPresent()) {
			return customer.get();
			
		}
		else {
			throw new AadharNumberNotMatchedException();
		}
	}

	

	
	
}
