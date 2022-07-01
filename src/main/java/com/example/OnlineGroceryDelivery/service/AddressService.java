package com.example.OnlineGroceryDelivery.service;

import java.util.List;

import com.example.OnlineGroceryDelivery.entity.Address;

public interface AddressService {

	Address saveEmployee(Address address);


	Address getAddressById(long id);


	String deleteAddress(long id);

	List<Address> getAddressList();


	Address updateAddress(long id, Address address);


	Address getAddressByStreetName(String streetName);


	List<Address> getAddressByCity(String city);





	

}
