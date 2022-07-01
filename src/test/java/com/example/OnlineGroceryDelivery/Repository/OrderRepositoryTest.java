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

import com.example.OnlineGroceryDelivery.entity.Order;
import com.example.OnlineGroceryDelivery.repository.OrderRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void saveOrderTest() {
		

		
		Order order =orderRepository.save(new Order(22L,"IN7654", "2500","PayPal", 4, "OrderPlaced","2022-01-30","2022-03-29"));
		
		
		Assertions.assertThat(order.getOrderId()).isGreaterThan(0);
	}
	
	
	@Test
     public void getOrderTest() {
		
		Order order =orderRepository.findById(22L).get();
		
		Assertions.assertThat(order.getOrderId()).isEqualTo(22L);
	}
	
	@Test
	public void getOrderList() {
		
	List<Order> order =orderRepository.findAll();
		
		Assertions.assertThat(order.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateOrderTest() {
		
		Order order =orderRepository.findById(22L).get();
		order.setStatus("OrderRecieved");

       Order updated = orderRepository.save(order);

       Assertions.assertThat(updated.getStatus()).isEqualTo("OrderRecieved");
}

	@Test
	public void deleteOrderTest() {
		
		Order ord =orderRepository.findById(26L).get();
		orderRepository.delete(ord);

        Order order=null;

        Optional<Order> ord1 =orderRepository.findByStatus("OrderInTransit");

       if(ord1. isPresent()){
	   order = ord1.get();
      }

      Assertions.assertThat(order).isNull();

}
	
	


}





