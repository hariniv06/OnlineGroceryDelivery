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
	private OrderRepository orderrepository;
	
	@Test
	public void saveOrderTest() {
		

		
		Order order =orderrepository.save(new Order(5000L,"Wq34","456","PayPal",9,"OrderRecieved"));
		
		
		Assertions.assertThat(order.getOrderId()).isGreaterThan(0);
	}
	
	
	@Test
     public void getOrderTest() {
		
		Order order =orderrepository.findById(5000L).get();
		
		Assertions.assertThat(order.getOrderId()).isEqualTo(5000L);
	}
	
	@Test
	public void getOrderList() {
		
	List<Order> order =orderrepository.findAll();
		
		Assertions.assertThat(order.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateOrderTest() {
		
		Order order =orderrepository.findById(5004L).get();
		order.setStatus("OrderInTransitToDelivery");

       Order updated = orderrepository.save(order);

       Assertions.assertThat(updated.getStatus()).isEqualTo("OrderInTransitToDelivery");
}

	@Test
	public void deleteOrderTest() {
		
		Order ord =orderrepository.findById(5007L).get();
		orderrepository.delete(ord);

        Order order=null;

        Optional<Order> ord1 =orderrepository.findByStatus("OrderDelivered");

       if(ord1. isPresent()){
	   order = ord1.get();
      }

      Assertions.assertThat(order).isNull();

}
	
	


}

