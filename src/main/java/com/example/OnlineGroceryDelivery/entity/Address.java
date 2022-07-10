package com.example.OnlineGroceryDelivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
   @Table(name="AddressTbl")
   
   
   public class Address {
	

   @Id
   @GeneratedValue(generator="seq1",strategy=GenerationType.AUTO)
   @SequenceGenerator(name="seq1",initialValue=100)
	 
	
    private long id;
	private long houseNo;
	
	@Column(nullable=false)
	@NotNull
	@NotBlank(message="Street Name is mandatory")
	@Size(min=1,max=15,message=" Street Name must be between 1 and 15")
	private String streetName;
	
	@Column(nullable=false)
	@NotNull
	private String city;
	
	
	private String state;
	
	@Transient
	private String country;
	
   
	private long pincode;
	
	@ManyToOne
	@JoinColumn(name="custId")
	@JsonIgnoreProperties("address")
    private Customer customer;
	
	
			
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public long getHouseNo() {
		return houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public long getPincode() {
		return pincode;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setHouseNo(long houseNo) {
		this.houseNo = houseNo;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Address(long id, long houseNo, String streetName, String city, String state, long pincode) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public Address(long id, long houseNo, String streetName, String city, String state, long pincode,
			Customer customer) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customer = customer;
	}
	
	
	public Address(long id, long houseNo, @NotNull String city) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", streetName=" + streetName + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", customer=" + customer + "]";
	}
}