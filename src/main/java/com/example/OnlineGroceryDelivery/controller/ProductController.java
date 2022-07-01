package com.example.OnlineGroceryDelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineGroceryDelivery.entity.Product;
import com.example.OnlineGroceryDelivery.service.ProductService;

@RestController
@RequestMapping("/api/product")

public class ProductController {
	
	@Autowired
	ProductService productservice;

	public ProductController(ProductService productservice) {
		super();
		// TODO Auto-generated constructor stub
		this.productservice =productservice;
	}
	
	@PostMapping
	  public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
	  return new ResponseEntity<Product>(productservice.saveProduct(product),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Product> getProductList()
	{
		return productservice.getProductList();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id")long id) {
		return productservice.getProductById(id);
		
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id")long id ,@RequestBody Product product) {
		return productservice.updateProduct(id,product);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id")long id ) {
		return new ResponseEntity<String>(productservice.deleteProduct(id),HttpStatus.OK);
		
	}
	@GetMapping("/GetByProductName/{productName}")
	public List <Product> getProductByProductName(@PathVariable("productName")String productName) {
		return productservice.getProductByProductName(productName);
	}	

	@GetMapping("/GetByProductCategory/{productCategory}")
	public List<Product> getProductByProductCategory(@PathVariable("productCategory")String productCategory) {
		return productservice.getProductByProductCategry(productCategory);
	}
	
	@GetMapping("/GetByProductCode/{productCode}")
	public Product getProductByProductCode(@PathVariable("productCode")String productCode) {
		return productservice.getProductByProductCode(productCode);
	}
	@GetMapping("/GetByProductPrice/{productPrice}")
	public Product getProductByProductPrice(@PathVariable("productPrice")long productPrice) {
		return productservice.getProductByProductPrice(productPrice);
		
}


}	
		
	


