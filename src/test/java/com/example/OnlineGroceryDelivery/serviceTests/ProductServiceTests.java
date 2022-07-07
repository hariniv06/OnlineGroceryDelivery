package com.example.OnlineGroceryDelivery.serviceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoProductFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.RecordAlreadyExistException;
import com.example.OnlineGroceryDelivery.repository.ProductRepository;
import com.example.OnlineGroceryDelivery.service.ProductServiceImpl;
import com.example.OnlineGroceryDelivery.entity.Product;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;



@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {
	
	@Mock
	private ProductRepository productrepository;
	
	
	@Autowired
	@InjectMocks
	private ProductServiceImpl productsService;
	
	
	private Product product1;
	private Product  product2;
	List<Product> productList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			productList = new ArrayList<>();
			
			product1 = new Product(400,"JackFruit","1kg");
			product2 = new Product(401,"Potato","500g");

	       productList.add(product1);
	       productList.add(product2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			product1 = product2= null;
			productList = null;
		}
		
		// To test saveProducts() method
		@DisplayName("Test for saveProducts() method")
		@Test
		public void givenProductToAddShouldReturnAddedProduct() {
			
			when(productrepository.save(product1)).thenReturn(product1);
			
			// when - behaviour that we are going test
			
			Product savedProducts = productsService.saveProduct(product1);
			
			System.out.println(savedProducts);
			assertThat(savedProducts).isNotNull();
			
		}
		
		// To test saveProducts() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveProductsThenThrowsException(){
	    	
	    	Product products = new Product(400,"JackFruit","1kg");
	    	
	        when(productrepository.findById(products.getProductId()))
	                .thenReturn(Optional.of(products));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            productsService.saveProduct(products);
	        });
	       
	    } 
	       
	    
	 // To Test getProductsList() method
		@Test
		public void givenGetAllProductssShouldReturnListOfAllProducts()throws NoRecordFoundException {
			
			productrepository.saveAll(productList);
			
			when(productrepository.findAll()).thenReturn(productList);
			
			List<Product> actualProductsList = productsService.getProductList();
	
			assertThat(actualProductsList).isEqualTo(productList);
		}
		
		@Test
		public void givenIdThenShouldReturnProductsOfThatId() throws GivenIdNotFoundException{
			
			when(productrepository.findById(400L)).thenReturn(Optional.ofNullable(product1));
			assertThat(productsService.getProductById(product1.getProductId())).isEqualTo(product1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteProductsOfThatId() {
			when(productrepository.findById(product1.getProductId())).thenReturn(Optional.ofNullable(product1));
			
	        assertThat(productsService.deleteProduct(product1.getProductId())).isEqualTo(" Product Record is Deleted Successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long productId = 5L;
			org.junit.jupiter.api.Assertions.assertThrows(NoProductFoundException.class, () ->  {
			productsService.deleteProduct(productId);
			});
		}
		
		   @DisplayName("JUnit test for UpdateProducts Method")
		    @Test
		    public void givenProductsObject_whenUpdateProducts_thenReturnUpdatedProducts(){
		    	long productId = 400L;
		        when(productrepository.findById(productId)).thenReturn(Optional.of(product1));
		        product1.setProductName("Banana");
		        Product updatedProducts = productsService.updateProduct(productId, product1);

		        assertThat(updatedProducts.getProductName()).isEqualTo("Banana");
		        
				System.out.println(updatedProducts);
				assertThat(updatedProducts).isNotNull();
		   }
		
		
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long productId = 5L;
			Product products = new Product();
			product1.setProductName("Banana");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        productsService.updateProduct(productId, products);
	});

	
	    }
	    
}

		
		
		
		
		
		
