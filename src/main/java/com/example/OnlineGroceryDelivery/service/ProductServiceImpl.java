package com.example.OnlineGroceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineGroceryDelivery.entity.Product;
import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoProductFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.RecordAlreadyExistException;
import com.example.OnlineGroceryDelivery.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productrepository;
	
	
	public ProductServiceImpl(ProductRepository productrepository) {
		super();
		// TODO Auto-generated constructor stub
		this.productrepository=productrepository;
	}
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> prod=productrepository.findById(product.getProductId());
		if(!prod.isPresent())
		return productrepository.save(product);
		else
			throw new RecordAlreadyExistException();
	}

	@Override
	public Product  getProductById(long productId) {
		// TODO Auto-generated method stub
		

		Optional<Product> product=productrepository.findById(productId);
		if(product.isPresent()) {
			return  product.get();
		}
		
		else {
			throw new GivenIdNotFoundException();
		}
		}


	@Override
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		
		List<Product> prod=productrepository.findAll();
		
		if (prod.isEmpty())
			throw new NoRecordFoundException();
		else
			return prod;

		//return productRepository.findAll();
	}

	@Override
	public Product updateProduct(long productId, Product product) {
		// TODO Auto-generated method stub
		
		Product prod=new Product ();
		prod=productrepository.findById(productId).orElseThrow (
			()-> new NoRecordFoundException());
		
		prod.setProductId(product.getProductId());
		prod.setProductName(product.getProductName());
		prod.setProductCode(product.getProductCode());
		prod.setProductCategory(product.getProductCategory());
		prod.setProductPrice(product.getProductPrice());
		prod.setQuantity_of_Product(product.getQuantity_of_Product());
		prod.setProductDescription(product.getProductDescription());
		
        productrepository.save(prod);
		return prod;
	}

	@Override
	public String deleteProduct(long productId) {
		// TODO Auto-generated method stub
		
		
		Product product = new Product();
		
		product=productrepository.findById(productId).orElseThrow(
				()-> new NoProductFoundException());

		
		
		productrepository.deleteById(productId);
		return "Record is Deleted Successfully";

	}
	@Override
	public List<Product> getProductByProductCategry(String productCategory) {
		// TODO Auto-generated method stub
		return productrepository.getProductByProductCategory( productCategory);
	}
	
	@Override
	public Product getProductByProductCode(String productCode) {
		// TODO Auto-generated method stub
		return productrepository.getProductByProductCode(productCode);
	}
	
	@Override
	public Product getProductByProductPrice(long productPrice) {
		// TODO Auto-generated method stub
		return productrepository.getProductByProductPrice(productPrice);
	}
	
	@Override
	public List<Product> getProductByProductName(String productName) {
		// TODO Auto-generated method stub
         return productrepository.getProductByProductName(productName);
	}
}

