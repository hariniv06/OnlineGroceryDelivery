package com.example.OnlineGroceryDelivery.service;

import java.util.List;

import com.example.OnlineGroceryDelivery.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getOrderList();

	Order getOrderById(long id);

	Order updateOrder(long id, Order order);

	String deleteOrder(long id);

	Order getOrderByOrderTrackingNumber(String orderTrackingNumber);

	List<Order> getOrderByOverallTotal(String overallTotal);

	
	Order getOrderByProductCount(long productCount);

	List<Order> getOrderByStatus(String status);

}
