package com.example.OnlineGroceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineGroceryDelivery.entity.Order;
import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.OrderNotFoundException;
import com.example.OnlineGroceryDelivery.exception.RecordAlreadyExistException;
import com.example.OnlineGroceryDelivery.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderrepository;
	
	
	
	public OrderServiceImpl(OrderRepository orderrepository) {
		super();
		// TODO Auto-generated constructor stub
		this.orderrepository=orderrepository;
	}

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		Optional<Order> or=orderrepository.findById(order.getOrderId());
		if(!or.isPresent())
		return orderrepository.save(order);
		else
			throw new RecordAlreadyExistException();

		
	}

	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		List<Order> orders =orderrepository.findAll();
		
		if (orders.isEmpty()) {
			throw new NoRecordFoundException();
			
		}
		
				else {
					return orders;
					
	}
	}


	@Override
	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Order> order=orderrepository.findById(id);
		if (order.isPresent()) {
		return order.get();
	}
		else {
			throw new GivenIdNotFoundException();
		}
	}
	@Override
	public Order updateOrder(long id, Order order) {
		// TODO Auto-generated method stub
		Order ord=new Order();
		ord=orderrepository.findById(id).orElseThrow(
		()-> new NoRecordFoundException());
		
		ord.setOrderId(order.getOrderId());
		ord.setOrderTrackingNumber(order.getOrderTrackingNumber());
		ord.setOverallTotal(order.getOverallTotal());
		ord.setPaymentMode(order.getPaymentMode());
		ord.setProductCount(order.getProductCount());
		ord.setStatus(order.getStatus());
		ord.setDateCreated(order.getDateCreated());
		ord.setDateUpdated(order.getDateUpdated());
		
		
		orderrepository.save(ord);
		return ord;
	}
	

	@Override
	public String deleteOrder(long id) {
		// TODO Auto-generated method stub
		Order order=new Order();
		order =orderrepository.findById(id).orElseThrow(
		()-> new OrderNotFoundException());
		
		orderrepository.deleteById(id);
		return "Record is deleted successfully";

}

	@Override
	public Order getOrderByOrderTrackingNumber(String orderTrackingNumber) {
		// TODO Auto-generated method stub
		return orderrepository.getOrderByOrderTrackingNumber(orderTrackingNumber);
	}

	@Override
	public List<Order> getOrderByOverallTotal(String overallTotal) {
		// TODO Auto-generated method stub
		return orderrepository.getOrderByOverallTotal(overallTotal);
	}

	@Override
	public Order getOrderByProductCount(long productCount) {
		// TODO Auto-generated method stub
		return orderrepository.getOrderByProductCount(productCount);
	}

	@Override
	public List<Order> getOrderByStatus(String status) {
		// TODO Auto-generated method stub
		return orderrepository.getOrderByStatus(status);
	}
}
	
		


	