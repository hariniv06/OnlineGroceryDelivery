package com.example.OnlineGroceryDelivery.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
    public class GlobalExceptionHandlers  {
	
	
	@ExceptionHandler(GivenIdNotFoundException.class)
	public ResponseEntity<Object> handleGivenIdNotFoundException(){
		return new ResponseEntity<Object>("Given Id is not available", HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(NoRecordFoundException.class)
	   public ResponseEntity<Object> handleNoRecordFoundException(){
		return new ResponseEntity<Object>("No record found !", HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(NoProductFoundException.class)
	   public ResponseEntity<Object> handleNoProductsFoundException()  {
		return new ResponseEntity<Object> (" Product Is Not Available" , HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler(AddressNotFoundException.class)
		public ResponseEntity<Object> handleNoAddressFoundException()  {
			return new ResponseEntity<Object> ("Given Address Is Not found" , HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(value= {MethodArgumentNotValidException.class })
		public ResponseEntity<Map<String, String>> handleValidationExceptions(
		  MethodArgumentNotValidException ex) {
	
			  
		   Map<String, String> errors = new HashMap<>();
		   ex.getBindingResult().getAllErrors().forEach((error) -> {
		    	
		     String fieldName =  ((FieldError) error).getField();
		     String errorMessage = error.getDefaultMessage();
		     errors.put(fieldName, errorMessage);
		        
  }
 );
		     return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
		}

		    @ExceptionHandler(AadharNumberNotMatchedException.class)
			public ResponseEntity<Object> handleAadharNumberNotMatchedException()  {
				return new ResponseEntity<Object> ("Given Aadhar Number Does Not Exist" , HttpStatus.NOT_ACCEPTABLE);
			}

		    @ExceptionHandler(OrderNotFoundException.class)
			public ResponseEntity<Object> OrderNotFoundException()  {
				return new ResponseEntity<Object> ("No order is found Here" , HttpStatus.NOT_FOUND);
		    }
		}
	



