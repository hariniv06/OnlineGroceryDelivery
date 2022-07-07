package com.example.OnlineGroceryDelivery.service;

import java.util.List;
import java.util.Map;

import com.example.OnlineGroceryDelivery.entity.Address;

public interface AddressService {


	Address getAddressById(long id);


	String deleteAddress(long id);

	List<Address> getAddressList();


	Address updateAddress(long id, Address address);


	Address saveAddress(Address address);


	Address getAddressByStreetName(String streetName);


	List<Address> getAddressByCity(String city);


	List<Address> getAddressByPinCode(long pincode);


	Map<Object, Object> getAddressGroupByCity();


	

	





	

}
