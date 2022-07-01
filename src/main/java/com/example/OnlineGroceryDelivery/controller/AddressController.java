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

import com.example.OnlineGroceryDelivery.entity.Address;
import com.example.OnlineGroceryDelivery.service.AddressService;

@RestController
@RequestMapping("/api/address")

public class AddressController {

	@Autowired
	AddressService addressservice;

	public AddressController(AddressService addressservice) {
		super();
		// TODO Auto-generated constructor stub
		this.addressservice = addressservice;
	}
	@PostMapping
	  public ResponseEntity<Address> saveEmployee( @Valid @RequestBody Address address) {
   	 return new ResponseEntity<Address>(addressservice.saveEmployee(address),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Address> getAddressList()
	{
		return addressservice.getAddressList();
	}
	
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable("id")long id) {
		return addressservice.getAddressById(id);
		
	}
	@PutMapping("/{id}")
	public Address updateAddress(@PathVariable("id")long id ,@RequestBody Address address) {
		return addressservice.updateAddress(id,address);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id")long id ) {
		return new ResponseEntity<String>(addressservice.deleteAddress(id),HttpStatus.OK);
		
	}
	
	@GetMapping("GetByStreetName/{streetName}")
	public Address getAddressByStreetName(@PathVariable("streetName")String streetName) {
		return addressservice.getAddressByStreetName(streetName);
		
}	

	@GetMapping("GetByCity/{city}")
	public List <Address> getAddressByCity(@PathVariable("city")String city) {
		return addressservice.getAddressByCity(city);
		
		
}	
	
}		
	

