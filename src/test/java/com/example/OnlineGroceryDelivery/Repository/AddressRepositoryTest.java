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

import com.example.OnlineGroceryDelivery.entity.Address;

import com.example.OnlineGroceryDelivery.repository.AddressRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;
	
	@Test
	public void saveAddressTest() {
		
		Address address =addressRepository.save(new Address(8L,155,"CidcoStreet", "Chennai","Tamilnadu",600001));
		
		Assertions.assertThat(address.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getAddressTest() {
		
		Address address =addressRepository.findById(8L).get();
		
		Assertions.assertThat(address.getId()).isEqualTo(8L);
	}
	
	@Test
	public void getAddressList() {
		
		List<Address> address =addressRepository.findAll();
		
		Assertions.assertThat(address.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateAddressTest() {
		
		Address address =addressRepository.findById(8L).get();
		
		address.setCity("Trichy");
		
		Address updated = addressRepository.save(address);
		
		Assertions.assertThat(updated.getCity()).isEqualTo("Trichy");
	}
	
	@Test
	public void deleteAddressTest() {
		
		Address adrs =addressRepository.findById(10L).get();
		
		addressRepository.delete(adrs);
		
		Address address=null;
		
		Optional<Address> adrs1 =addressRepository.findByCity("Coimbatore");
		
		if(adrs1. isPresent()){
			address = adrs1.get();
		}
		
		Assertions.assertThat(address).isNull();
		
	}
	
	


}
