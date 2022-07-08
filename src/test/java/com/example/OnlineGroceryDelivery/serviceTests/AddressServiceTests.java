package com.example.OnlineGroceryDelivery.serviceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.AddressNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.RecordAlreadyExistException;
import com.example.OnlineGroceryDelivery.repository.AddressRepository;
import com.example.OnlineGroceryDelivery.service.AddressServiceImpl;
import com.example.OnlineGroceryDelivery.entity.Address;

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
public class AddressServiceTests {
	
	@Mock
	private AddressRepository addressrepository;
	
	
	@Autowired
	@InjectMocks
	private AddressServiceImpl addressservice;
	
	
	private Address address1;
	private Address address2;
	List<Address> addressList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			addressList = new ArrayList<>();
			
			address1 = new Address(201,876,"Gujarat");
			address2 = new  Address(202,765,"Punjab");
			
	       addressList.add(address1);
	       addressList.add(address2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			address1 =address2= null;
			addressList = null;
		}
		
		// To test saveAddress() method
		@DisplayName("Test for saveAddress() method")
		@Test
		public void givenAddressToAddShouldReturnAddedAddress() {
			
			when(addressrepository.save(address1)).thenReturn(address1);
			
			// when - behaviour that we are going test
			
			Address savedAddress = addressservice.saveAddress(address1);
			
			System.out.println(savedAddress);
			assertThat(savedAddress).isNotNull();
			
		}
		
		// To test saveAddress() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveAddressThenThrowsException(){
	    	
	    	Address address = new Address(201L,876,"Gujarat");
	    	
	        when(addressrepository.findById(address.getId()))
	                .thenReturn(Optional.of(address));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            addressservice.saveAddress(address);
	        });
	       
	    } 
	       
	    
	 // To Test getAddressList() method
		@Test
		public void givenGetAllAddressShouldReturnListOfAllAddress()throws NoRecordFoundException {
			
			addressrepository.saveAll(addressList);
			
			when(addressrepository.findAll()).thenReturn(addressList);
			
			List<Address> actualAddressList = addressservice.getAddressList();
			
			assertThat(actualAddressList).isEqualTo(addressList);
		}
		
		@Test
		public void givenIdThenShouldReturnAddressOfThatId() throws GivenIdNotFoundException{
			
			when(addressrepository.findById(201L)).thenReturn(Optional.ofNullable(address1));
			assertThat(addressservice.getAddressById(address1.getId())).isEqualTo(address1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteAddressOfThatId() {
			when(addressrepository.findById(address1.getId())).thenReturn(Optional.ofNullable(address1));
			
	        assertThat(addressservice.deleteAddress(address1.getId())).isEqualTo("Record is deleted successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long id = 7L;
			org.junit.jupiter.api.Assertions.assertThrows(AddressNotFoundException.class, () ->  {
				addressservice.deleteAddress(id);
			});
		}
		
		
		
	   @DisplayName("JUnit test for UpdateAddress method")
	    @Test
	    public void givenAddressObject_whenUpdateAddress_thenReturnUpdatedAddress(){
	    	long id = 201L;
	        when(addressrepository.save(address1)).thenReturn(address1);
	        when(addressrepository.findById(id)).thenReturn(Optional.of(address1));
	        address1.setCity("Patna");
	        Address updatedAddress = addressservice.updateAddress(id, address1);

	        assertThat(updatedAddress.getCity()).isEqualTo("Patna");
	      
			System.out.println(updatedAddress);
			assertThat(updatedAddress).isNotNull();

	    }
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long id = 7L;
			Address address = new Address();
			address1.setCity("Patna");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        addressservice.updateAddress(id, address);
	});

	
	    }
	    
}

		
		
		
		
		
