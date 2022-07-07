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
	private ProductRepository productrepository;
	
	@Test
	public void saveProductTest() {
		
		Product product =productrepository.save(new Product(1000L,"Betroot","VV90","Vegetables",350,"3","GoodForHealth"));
		
		Assertions.assertThat(product.getProductId()).isGreaterThan(0);
	}
	
	@Test
	public void getProductTest() {
		
		Product product =productrepository.findById(1000L).get();
		
		Assertions.assertThat(product.getProductId()).isEqualTo(1000L);
	}
	
	@Test
	public void getProductList() {
		
		List<Product> product =productrepository.findAll();
		
		Assertions.assertThat(product.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateProductTest() {
		
		Product product =productrepository.findById(1000L).get();
		
		product.setProductName("Carrot");
		
		Product updated = productrepository.save(product);
		
		Assertions.assertThat(updated.getProductName()).isEqualTo("Carrot");
	}
	
	@Test
	public void deleteProductTest() {
		
		Product prd =productrepository.findById(1101L).get();
		
		productrepository.delete(prd);
		
		Product product=null;
		
		Optional<Product> prd1 =productrepository.findByProductName("RiceFlour");
		
		if(prd1. isPresent()){
			product = prd1.get();
		}
		
		Assertions.assertThat(product).isNull();
		
	}
	
}


