package com.example.OnlineGroceryDelivery.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="customerTbl")
public class Customer {
	
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 
 private long custId;
 
 @Column(nullable=false)
 @NotNull
 @NotBlank(message="Customer name is mandatory")
 @Size(min=3,max=20,message="Name must be between 2 and 32 characters long")
 private String customerName;
	
 @Column(nullable=false)
 @NotNull
 @NotBlank(message="Sur name is mandatory")
 private String surName;
	
 @Column(nullable=false,unique=true)
 @NotBlank(message="Email is mandatory")
 @Email(message="Invalid email id")
 private String email;
 private long aadharNumber;
 private String contactNo;
 
 @Transient
  private String password;
 
 @OneToMany(mappedBy="customer")
 @JsonIgnoreProperties("customer")
  private List<Address> address;

 @OneToMany(mappedBy="customer")
 @JsonIgnoreProperties("customer")
  private List<Order> order;
 
 
 
public List<Address> getAddress() {
	return address;
}
public List<Order> getOrder() {
	return order;
}
public void setAddress(List<Address> address) {
	this.address = address;
}
public void setOrder(List<Order> order) {
	this.order = order;
}
public long getCustId() {
	return custId;
}
public String getCustomerName() {
	return customerName;
}
public String getSurName() {
	return surName;
}
public String getEmail() {
	return email;
}
public long getAadharNumber() {
	return aadharNumber;
}
public String getContactNo() {
	return contactNo;
}
public void setCustId(long custId) {
	this.custId = custId;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public void setSurName(String surName) {
	this.surName = surName;
}
public void setEmail(String email) {
	this.email = email;
}
public void setAadharNumber(long aadharNumber) {
	this.aadharNumber = aadharNumber;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}


public Customer(long custId, @NotNull @NotBlank(message = "Customer name is mandatory") String customerName,
		@NotNull @NotBlank(message = "Sur name is mandatory") String surName,
		@NotBlank(message = "Email is mandatory") @Email(message = "Invalid email id") String email, long aadharNumber,
		String contactNo) {
	super();
	this.custId = custId;
	this.customerName = customerName;
	this.surName = surName;
	this.email = email;
	this.aadharNumber = aadharNumber;
	this.contactNo = contactNo;
}


public Customer(long custId, @NotNull @NotBlank(message = "Customer name is mandatory") String customerName,
		@NotNull @NotBlank(message = "Sur name is mandatory") String surName,
		@NotBlank(message = "Email is mandatory") @Email(message = "Invalid email id") String email, long aadharNumber,
		String contactNo, List<Address> address, List<Order> order) {
	super();
	this.custId = custId;
	this.customerName = customerName;
	this.surName = surName;
	this.email = email;
	this.aadharNumber = aadharNumber;
	this.contactNo = contactNo;
	this.address = address;
	this.order = order;
}
@Override
public String toString() {
	return "Customer [custId=" + custId + ", customerName=" + customerName + ", surName=" + surName + ", email=" + email
			+ ", aadharNumber=" + aadharNumber + ", contactNo=" + contactNo + ", address=" + address + ", order="
			+ order + "]";
}

}
      
 
    