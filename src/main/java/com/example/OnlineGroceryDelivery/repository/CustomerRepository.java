package com.example.OnlineGroceryDelivery.repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.OnlineGroceryDelivery.entity.Customer;

    
     public interface CustomerRepository extends JpaRepository<Customer,Long>{


	  

    	 @Query("select c from CustomerTbl c where c.customerName =:customerName")
    	 List<Customer> getCustomerByCustomerName(@Param("customerName")String customerName);



     	@Query("select c from CustomerTbl c where c.surName =:surName")
 	    List<Customer> getCustomerBySurName(@Param("surName")String surName);

 	

     	@Query("select c from CustomerTbl c where c.email =:email")
 	    List<Customer> getCustomerByEmail(@Param ("email")String email);


 	    Optional<Customer> findByEmail(String string);

 	

 	    Optional<Customer> findByAadharNumber(long aadharNumber);


 	   @Query ("select c.customerName , count(c.id) from CustomerTbl c group by c.customerName")
		List<Object[]> getCustomerGroupByCustomerName();


 	 
		



	


	

}
	  


	


	


