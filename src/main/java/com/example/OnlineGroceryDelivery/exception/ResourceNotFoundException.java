package com.example.OnlineGroceryDelivery.exception;
public class ResourceNotFoundException extends RuntimeException
{
	private String resourceName;
	private String fieldname;
	private long fieldvalue;
	public ResourceNotFoundException(String resourceName,String fieldname,long id) {
		super();
	
	this.resourceName = resourceName;
	this.fieldname =fieldname;
	
	this.fieldvalue =id;
	
	
	

}
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldname() {
		return fieldname;
	}
	public long getFieldvalue() {
		return fieldvalue;
	}
}
