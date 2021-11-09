package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureOrder;
import com.entity.FurnitureUser;
import com.exception.OrderServiceException;
import com.exception.UserNotFoundException;
import com.service.OrderCancellationServiceInterface;

@RestController
@RequestMapping("/api/showOrderCancellation")
public class OrderCancellationController {

	@Autowired
	OrderCancellationServiceInterface ordercancellation;

	
	
	@DeleteMapping(path = "/deleteFurnitureOrder/{orderId}")
	public  ResponseEntity<FurnitureOrder> deleteOrderById(@PathVariable("orderId") String orderId) throws OrderServiceException {
		
		FurnitureOrder order4 =ordercancellation .deleteOrderById("orderId");
		return new ResponseEntity<FurnitureOrder>(order4, HttpStatus.OK);
		

	}

	
	@DeleteMapping(path = "/deleteOrder")
	public String deleteOrder() throws OrderServiceException {
		String order3 = ordercancellation.deleteOrder();
		return "Deletion Completed for" + order3;
	}

}


