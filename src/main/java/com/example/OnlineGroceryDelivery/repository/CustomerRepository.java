package com.example.OnlineGroceryDelivery.repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineGroceryDelivery.entity.Customer;

    @Repository
     public interface CustomerRepository extends JpaRepository<Customer,Long>{

    	@Query("select c from customerTbl c where c.customerName =:customerName")

    	List<Customer> getCustomerByCustomerName(@Param("customerName")String customerName);



    	@Query("select c from customerTbl c where c.surName =:surName")
	    List<Customer> getCustomerBySurName(String surName);

	

    	@Query("select c from customerTbl c where c.email =:email")
	    List<Customer> getCustomerByEmail(String email);


	    Optional<Customer> findByEmail(String string);

	

	    Optional<Customer> findByAadharNumber(long aadharNumber);



	


	

}
