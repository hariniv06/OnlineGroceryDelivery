package com.example.OnlineGroceryDelivery.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

   @Entity
   @Table(name="OrderTbl")
  
   public class Order  implements Serializable{
   @Id
   @GeneratedValue(generator="seq3",strategy=GenerationType.AUTO)
   @SequenceGenerator(name="seq3",initialValue=5000)

    
    private long orderId;
   
    private String orderTrackingNumber;
    
    @Column(nullable=false)
	@NotNull
	private String overallTotal;
	
    @Column(nullable=false)
	@NotNull
	@NotBlank(message="Payment Mode is Mandatory")
	@Size(min=6,max=29)
	private String paymentMode;
    
   
	private long productCount;
	@Column(nullable=false)
	@NotNull
	private String status;
	
	@Transient
	private String orderPattern;
	private Date dateCreated;
	private Date dateUpdated;
   
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public Date getDateUpdated() {
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
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
		
	
	public Order(long orderId, @NotNull String overallTotal,
			@NotNull @NotBlank(message = "Payment Mode is Mandatory") @Size(min = 6, max = 29) String paymentMode) {
		super();
		this.orderId = orderId;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
	}
	
	public Order(long orderId, String orderTrackingNumber, String overallTotal, String paymentMode, long productCount,
			String status) {
		super();
		this.orderId = orderId;
		this.orderTrackingNumber = orderTrackingNumber;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
		this.productCount = productCount;
		this.status = status;
	}
	
	public Order(long orderId, String orderTrackingNumber, String overallTotal, String paymentMode, long productCount,
			String status, Date dateCreated, Date dateUpdated, Customer customer, List<Product> product) {
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
 
    