package com.example.OnlineGroceryDelivery.serviceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.RecordAlreadyExistException;
import com.example.OnlineGroceryDelivery.repository.CustomerRepository;
import com.example.OnlineGroceryDelivery.service.CustomerServiceImpl;
import com.example.OnlineGroceryDelivery.entity.Customer;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;



@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {
	
	@Mock
	private CustomerRepository customerrepository;
	
	
	@Autowired
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	
	private Customer customer1;
	private Customer  customer2;
	List<Customer> customerList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			customerList = new ArrayList<>();
			
			customer1 = new Customer(300,"Ananya","ananya@gmail.com");
			customer2 = new Customer(301,"Anusha","anusha@gamail.com");
			
	       customerList.add(customer1);
	       customerList.add(customer2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			customer1 = customer2= null;
			customerList = null;
		}
		
		// To test saveCustomer() method
		@DisplayName("Test for saveCustomer() method")
		@Test
		public void givenCustomerToAddShouldReturnAddedCustomer() {
			
			when(customerrepository.save(customer1)).thenReturn(customer1);
			
			// when - behaviour that we are going test
			
			Customer savedCustomer = customerService.saveCustomer(customer1);
			
			System.out.println(savedCustomer);
			assertThat(savedCustomer).isNotNull();
			
		}
		
		// To test saveCustomer() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveCustomerThenThrowsException(){
	    	
	    	Customer customer = new Customer(300,"Ananya" , "ananya@gmail.com");
	    	
	        when(customerrepository.findById(customer.getCustId()))
	                .thenReturn(Optional.of(customer));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            customerService.saveCustomer(customer);
	        });
	       
	    } 
	       
	    
	 // To Test getCustomerList() method
		@Test
		public void givenGetAllCustomersShouldReturnListOfAllCustomers()throws NoRecordFoundException {
			
			customerrepository.saveAll(customerList);
			
			when(customerrepository.findAll()).thenReturn(customerList);
			
			List<Customer> actualCustomerList = customerService.getCustomerList();
			
			assertThat(actualCustomerList).isEqualTo(customerList);
		}
		
		@Test
		public void givenIdThenShouldReturnEmployeeOfThatId() throws GivenIdNotFoundException{
			
			when(customerrepository.findById(300L)).thenReturn(Optional.ofNullable(customer1));
			assertThat(customerService.getCustomerById(customer1.getCustId())).isEqualTo(customer1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteCustomerOfThatId() {
			when(customerrepository.findById(customer1.getCustId())).thenReturn(Optional.ofNullable(customer1));
			
	        assertThat(customerService.deleteCustomer(customer1.getCustId())).isEqualTo("Record is deleted successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long custId = 3L;
			org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () ->  {
				customerService.deleteCustomer(custId);
			});
		}
		
		
		
	   @DisplayName("JUnit test for UpdateCustomer method")
	    @Test
	    public void givenCustomerObject_whenUpdateCustomer_thenReturnUpdatedCustomer(){
	    	long custId = 300L;
	        when(customerrepository.save(customer1)).thenReturn(customer1);
	        when(customerrepository.findById(custId)).thenReturn(Optional.of(customer1));
	        customer1.setEmail("Anandhi@gmail.com");
	        customer1.setCustomerName("Asha");
	        Customer updatedCustomer = customerService.updateCustomer(custId, customer1);

	        assertThat(updatedCustomer.getEmail()).isEqualTo("Anandhi@gmail.com");
	      assertThat(updatedCustomer.getCustomerName()).isEqualTo("Asha");
	      
			System.out.println(updatedCustomer);
			assertThat(updatedCustomer).isNotNull();

	    }
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long custId = 3L;
			Customer customer = new Customer();
			customer1.setEmail("Anandhi@gmail.com");
	       customer1.setCustomerName("Asha");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        customerService.updateCustomer(custId, customer);
	});

	
	    }
	    
}

		
		
		
		
		
