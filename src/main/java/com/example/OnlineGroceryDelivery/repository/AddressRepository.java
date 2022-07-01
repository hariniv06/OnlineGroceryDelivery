package com.example.OnlineGroceryDelivery.repository;





import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.OnlineGroceryDelivery.entity.Address;



public interface AddressRepository extends JpaRepository<Address,Long>{

	Optional<Address> findByCity(String string);

	
	@Query("select a from addressTbl a where a.streetName =:streetName")
	Address getAddressByStreetName( @Param ("streetName")String streetName);

	

	@Query("select a from  addressTbl a where a.city =:city")
     List<Address> getAddressByCity(@Param("city")String city);


	
	
	
	}

	

	
