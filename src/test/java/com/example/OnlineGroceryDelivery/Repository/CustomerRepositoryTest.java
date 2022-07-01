package com.example.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.OnlineGroceryDelivery.entity.Customer;
import com.example.OnlineGroceryDelivery.repository.CustomerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)

public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void saveCustomerTest() {
		
		Customer customer =customerRepository.save(new Customer(1L, "Tiya","D", "tiya@gmail.com",98765,"76543"));
	     
		
		Assertions.assertThat(customer.getCustId()).isGreaterThan(0);
	}
	
	@Test
	public void getCustomerTest() {
		
		Customer customer =customerRepository.findById(1L).get();
		
		Assertions.assertThat(customer.getCustId()).isEqualTo(1L);
	}
	
	@Test
	public void getCustomerList() {
		
		List<Customer> customer =customerRepository.findAll();
		
		Assertions.assertThat(customer.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateCustomerTest() {
		
		Customer customer =customerRepository.findById(1L).get();
		
		customer.setEmail("dtiya@gmail.com");
		
		Customer updated = customerRepository.save(customer);
		
		Assertions.assertThat(updated.getEmail()).isEqualTo("dtiya@gmail.com");
	}
	
	@Test
	public void deleteCustomerTest() {
		
		Customer cust =customerRepository.findById(2L).get();
		
		customerRepository.delete(cust);
		
		Customer customer=null;
		
		Optional<Customer> cust1 =customerRepository.findByEmail("riya@gmail.com");
		
		if(cust1.isPresent()) {
			customer = cust1.get();
		}
		
		Assertions.assertThat(customer).isNull();
		
	}
	
	
}
