package com.example.OnlineGroceryDelivery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.OnlineGroceryDelivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	Optional<Order> findByStatus(String string);

	Order getOrderByOrderTrackingNumber(String orderTrackingNumber);
	
	@Query("select o from orderTbl o where o.overallTotal =:overallTotal")
	List<Order> getOrderByOverallTotal(String overallTotal);

	@Query("select o from orderTbl o where o.productCount =:productCount")
	Order getOrderByProductCount(long productCount);


	@Query("select o from orderTbl o where o.status =:status")
      List<Order> getOrderByStatus(@Param("status")String status);



}
