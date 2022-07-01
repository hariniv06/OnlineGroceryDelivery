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

import com.example.OnlineGroceryDelivery.entity.Product;
import com.example.OnlineGroceryDelivery.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void saveProductTest() {
		
		Product product =productRepository.save(new Product(17L,"Carrot","Rs13","Vegetables",350,"3","GoodForHealth"));
		
		Assertions.assertThat(product.getProductId()).isGreaterThan(0);
	}
	
	@Test
	public void getProductTest() {
		
		Product product =productRepository.findById(17L).get();
		
		Assertions.assertThat(product.getProductId()).isEqualTo(17L);
	}
	
	@Test
	public void getProductList() {
		
		List<Product> product =productRepository.findAll();
		
		Assertions.assertThat(product.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateProductTest() {
		
		Product product =productRepository.findById(17L).get();
		
		product.setProductName("Betroot");
		
		Product updated = productRepository.save(product);
		
		Assertions.assertThat(updated.getProductName()).isEqualTo("Betroot");
	}
	
	@Test
	public void deleteProductTest() {
		
		Product prd =productRepository.findById(16L).get();
		
		productRepository.delete(prd);
		
		Product product=null;
		
		Optional<Product> prd1 =productRepository.findByProductName("Betroot");
		
		if(prd1. isPresent()){
			product = prd1.get();
		}
		
		Assertions.assertThat(product).isNull();
		
	}
	
	


}


