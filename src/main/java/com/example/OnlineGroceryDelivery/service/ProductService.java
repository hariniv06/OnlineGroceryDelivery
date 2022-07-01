package com.example.OnlineGroceryDelivery.service;

import java.util.List;

import com.example.OnlineGroceryDelivery.entity.Product;

public interface ProductService {

	

	List<Product> getProductList();

	Product getProductById(long productId);

	Product updateProduct(long productId, Product product);

	String deleteProduct(long productId);

	List<Product> getProductByProductName(String productName);

	Product saveProduct(Product product);

	List<Product> getProductByProductCategry(String productCategory);


	Product getProductByProductCode(String productCode);

	Product getProductByProductPrice(long productPrice);



	

	

}