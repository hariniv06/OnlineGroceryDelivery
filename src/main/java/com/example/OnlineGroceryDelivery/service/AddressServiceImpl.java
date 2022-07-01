package com.example.OnlineGroceryDelivery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.OnlineGroceryDelivery.entity.Address;
import com.example.OnlineGroceryDelivery.exception.GivenIdNotFoundException;
import com.example.OnlineGroceryDelivery.exception.AddressNotFoundException;
import com.example.OnlineGroceryDelivery.exception.NoRecordFoundException;
import com.example.OnlineGroceryDelivery.exception.ResourceNotFoundException;
import com.example.OnlineGroceryDelivery.repository.AddressRepository;




@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressrepository;
	
	
	
	public AddressServiceImpl(AddressRepository addressrepository) {
		super();
		// TODO Auto-generated constructor stub
	    this.addressrepository = addressrepository;
	}
	

	@Override
	public Address saveEmployee(Address address) {
		
		return addressrepository.save(address);
	}

	@Override
	public List<Address> getAddressList() {
		// TODO Auto-generated method stub
		List<Address>addresses=addressrepository.findAll();
		
		if (addresses.isEmpty()) {
			throw new NoRecordFoundException();
			
		}
		
				else {
					return addresses;
					
	}
	}

	
	@Override
	public Address getAddressById(long id) {
		// TODO Auto-generated method stub
		Optional<Address> address=addressrepository.findById(id);
		if (address.isPresent()) {
		return address.get();
	}
		else {
			throw new AddressNotFoundException();

	}

	}
	@Override
	public Address updateAddress(long id, Address address) {
		// TODO Auto-generated method stub
		Address adrs=new Address();
		adrs=addressrepository.findById(id).orElseThrow(
		()-> new ResourceNotFoundException("Address","Id",id));
		
	    adrs.setHouseNo(address.getHouseNo());
	    adrs.setStreetName(address.getStreetName());
	    adrs.setCity(address.getCity());
	    adrs.setState(address.getState());
	    adrs.setPincode(address.getPincode());
	    
		addressrepository.save(adrs);
		return adrs;
	}


	@Override
	public String deleteAddress(long id) {
		// TODO Auto-generated method stub
		Address address=new Address();
		address =addressrepository.findById(id).orElseThrow(
		()-> new ResourceNotFoundException("Address","Id",id));
		
		addressrepository.deleteById(id);
		return "Record is deleted successfully";
	}


	@Override
	public Address getAddressByStreetName(String streetName) {
		// TODO Auto-generated method stub
		return addressrepository.getAddressByStreetName(streetName); 
	}

	@Override
	public List<Address> getAddressByCity(String city) {
		// TODO Auto-generated method stub
		return addressrepository.getAddressByCity(city); 
	}

	
	
	
}



	


