package com.example.OnlineGroceryDelivery.entity;




import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="orderTbl")

public class Order  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long orderId;
	private String orderTrackingNumber;
	@Column(nullable=false)
	@NotNull
	private String overallTotal;
	@Column(nullable=false)
	@NotNull
	@NotBlank(message="Payment Mode is Mandatory")
	@Size(min=6,max=29,message="Payment Mode must be between 6 and 29")
	private String paymentMode;
	private long productCount;
	
	private String status;
	@Transient
	private String orderPattern;
	private String dateCreated;
	private String dateUpdated;
	
	@ManyToOne
	@JoinColumn(name="custId")
	@JsonIgnoreProperties("order")
	private Customer customer;
	
	@ManyToMany
	@JsonIgnoreProperties("order")
	private List<Product>product;

	
			
	public Customer getCustomer() {
		return customer;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public long getOrderId() {
		return orderId;
	}
	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
	public String getOverallTotal() {
		return overallTotal;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public long getProductCount() {
		return productCount;
	}
	public String getStatus() {
		return status;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}
	public void setOverallTotal(String overallTotal) {
		this.overallTotal = overallTotal;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public void setProductCount(long productCount) {
		this.productCount = productCount;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderId, String orderTrackingNumber, String overallTotal, String paymentMode, long productCount,
			String status, String dateCreated, String dateUpdated) {
		super();
		this.orderId = orderId;
		this.orderTrackingNumber = orderTrackingNumber;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
		this.productCount = productCount;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}
	
	public Order(long orderId, String orderTrackingNumber, String overallTotal, String paymentMode, long productCount,
			String status, String dateCreated, String dateUpdated, Customer customer, List<Product> product) {
		super();
		this.orderId = orderId;
		this.orderTrackingNumber = orderTrackingNumber;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
		this.productCount = productCount;
		this.status = status;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.customer = customer;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderTrackingNumber=" + orderTrackingNumber + ", overallTotal="
				+ overallTotal + ", paymentMode=" + paymentMode + ", productCount=" + productCount + ", status="
				+ status + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", customer=" + customer
				+ ", product=" + product + "]";
	}
	
}

	
