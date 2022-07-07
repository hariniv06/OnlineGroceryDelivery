package com.example.OnlineGroceryDelivery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

      @Entity(name="ProductTbl")
  
  
       public class Product implements Serializable {

	   @Id
	   @GeneratedValue(generator="seq2",strategy=GenerationType.AUTO)
	   @SequenceGenerator(name="seq2",initialValue=1000)
	
	
	    private long productId;
	    @NotNull
	    @NotBlank(message="Product Name is Mandatory")
		private String productName;
		private String productCode;
		
		@Column(nullable=false)
		@NotNull
		private String productCategory;

		
		@Range(min=1,max=100000)
		private long productPrice;
		private String quantity_of_Product;
		
	    @Transient
		private String productIssue;
	    
	    @NotBlank(message="Product Description is Mandatory")
		private String productDescription;
		
		@ManyToMany(mappedBy="product")
		@JsonIgnoreProperties("product")
		private List<Order>order;

		
		public List<Order> getOrder() {
			return order;
		}
		public void setOrder(List<Order> order) {
			this.order = order;
		}
		public long getProductId() {
			return productId;
		}
		public String getProductName() {
			return productName;
		}
		public String getProductCode() {
			return productCode;
		}
		public String getProductCategory() {
			return productCategory;
		}
		public long getProductPrice() {
			return productPrice;
		}
		public String getQuantity_of_Product() {
			return quantity_of_Product;
		}
		public String getProductDescription() {
			return productDescription;
		}
		public void setProductId(long productId) {
			this.productId = productId;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}
		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}
		public void setProductPrice(long productPrice) {
			this.productPrice = productPrice;
		}
		public void setQuantity_of_Product(String quantity_of_Product) {
			this.quantity_of_Product = quantity_of_Product;
		}
		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		public Product(long productId, @NotNull @NotBlank(message = "Product Name is Mandatory") String productName,
				String quantity_of_Product) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.quantity_of_Product = quantity_of_Product;
		}
		public Product(long productId, String productName, String productCode, String productCategory, long productPrice,
				String quantity_of_Product, String productDescription) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCode = productCode;
			this.productCategory = productCategory;
			this.productPrice = productPrice;
			this.quantity_of_Product = quantity_of_Product;
			this.productDescription = productDescription;
		}
		
		public Product(long productId, String productName, String productCode, String productCategory, long productPrice,
				String quantity_of_Product, String productDescription, List<Order> order) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productCode = productCode;
			this.productCategory = productCategory;
			this.productPrice = productPrice;
			this.quantity_of_Product = quantity_of_Product;
			this.productDescription = productDescription;
			this.order = order;
		}
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
					+ ", productCategory=" + productCategory + ", productPrice=" + productPrice + ", quantity_of_Product="
					+ quantity_of_Product + ", productDescription=" + productDescription + ", order=" + order + "]";
		}
		
	}