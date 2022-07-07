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
	private CustomerRepository customerrepository;
	
	@Test
	public void saveCustomerTest() {
		
		Customer customer =customerrepository.save(new Customer(17L, "Riya","N", "riya@gmail.com","EQ89",7888885));
	     
		
		Assertions.assertThat(customer.getCustId()).isGreaterThan(0);
	}
	
	@Test
	public void getCustomerTest() {
		
		Customer customer =customerrepository.findById(17L).get();
		
		Assertions.assertThat(customer.getCustId()).isEqualTo(17L);
	}
	
	@Test
	public void getCustomerList() {
		
		List<Customer> customer =customerrepository.findAll();
		
		Assertions.assertThat(customer.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateCustomerTest() {
		
		Customer customer =customerrepository.findById(17L).get();
		
		customer.setEmail("nriya@gmail.com");
		
		Customer updated = customerrepository.save(customer);
		
		Assertions.assertThat(updated.getEmail()).isEqualTo("nriya@gmail.com");
	}
	
	@Test
	public void deleteCustomerTest() {
		
		Customer cust =customerrepository.findById(62L).get();
		
		customerrepository.delete(cust);
		
		Customer customer=null;
		
		Optional<Customer> cust1 =customerrepository.findByEmail("nehaa@gmail.com");
		
		if(cust1.isPresent()) {
			customer = cust1.get();
		}
		
		Assertions.assertThat(customer).isNull();
		
	}
	
	
}
