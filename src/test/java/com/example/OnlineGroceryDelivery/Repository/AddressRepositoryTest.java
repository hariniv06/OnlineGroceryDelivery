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
		private AddressRepository addressrepository;
		
		@Test
		public void saveAddressTest() {
			
			Address address =addressrepository.save(new Address(101L,198,"AIEastStreet", "Mumbai","Maharashtra",411041));
			
			Assertions.assertThat(address.getId()).isGreaterThan(0);
		}
		
		@Test
		public void getAddressTest() {
			
			Address address =addressrepository.findById(101L).get();
			
			Assertions.assertThat(address.getId()).isEqualTo(101L);
		}
		
		@Test
		public void getAddressList() {
			
			List<Address> address =addressrepository.findAll();
			
			Assertions.assertThat(address.size()).isGreaterThan(0);
		}
		
		@Test
		public void updateAddressTest() {
			
			Address address =addressrepository.findById(101L).get();
			
			address.setCity("Thane");
			
			Address updated = addressrepository.save(address);
			
			Assertions.assertThat(updated.getCity()).isEqualTo("Thane");
		}
		
		@Test
		public void deleteAddressTest() {
			
			Address adrs =addressrepository.findById(103L).get();
			
			addressrepository.delete(adrs);
			
			Address address=null;
			
			Optional<Address> adrs1 =addressrepository.findByCity("Coimbatore");
			
			if(adrs1. isPresent()){
				address = adrs1.get();
			}
			
			Assertions.assertThat(address).isNull();
			
		}
		
		


	}