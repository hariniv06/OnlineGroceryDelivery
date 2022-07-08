package com.example.OnlineGroceryDelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.OnlineGroceryDelivery.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Long>{

	

	Optional<Product> findByProductName(String string);

	  
    @Query("select p from ProductTbl p where p.productName =:productName")
   	List<Product> getProductByProductName(@Param("productName")String productName);

    @Query("select p from ProductTbl p where p.productCategory =:productCategory")
	List<Product> getProductByProductCategory(@Param("productCategory")String productCategory);

	
    @Query("select p from ProductTbl p where p.productPrice =:productPrice")
	Product getProductByProductPrice(@Param("productPrice")long productPrice);

    @Query("select p from ProductTbl p where p.productCode =:productCode")
	Product getProductByProductCode(@Param("productCode")String productCode);

    @Query ("select p.productCategory , count(p.id) from ProductTbl p group by p.productCategory")
	List<Object[]> getProductGroupByProductCategory();


	

}
	  
    

