package com.example.OnlineGroceryDelivery.service;

import java.util.List;

import com.example.OnlineGroceryDelivery.entity.Customer;

public interface CustomerService {

	 Customer saveCustomer(Customer customer);

	 List<Customer> getCustomerList();

	 Customer getCustomerById(long id);

	 Customer updateCustomer(long id, Customer customer);

	 String deleteCustomer(long id);

	List<Customer> getCustomerByCustomerName(String customerName);

	List<Customer> getCustomerBySurName(String surName);

	List<Customer> getCustomerByEmail(String email);

	Customer getCustomerByAadharNumber(long aadharNumber);
}
