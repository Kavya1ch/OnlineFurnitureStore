package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.FurnitureServiceException;
import com.exception.UserNotFoundException;
import com.service.OrderServiceInterface;


@RestController
@RequestMapping("/api/Order")

public class OrderController {

	@Autowired
	public OrderServiceInterface osi;

	
	@PutMapping(path = "/updateOrder")
	public String updateOrder(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder user1 = osi.updateOrder(order);
		return "User Updated Successfully" + user1;
	}

	
	@PutMapping(path = "/updateOrderById/{orderId}")
	public ResponseEntity<FurnitureOrder> updateOrderById(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		
		FurnitureOrder user2 = osi.updateOrderById(order.getOrderId(), order);
		ResponseEntity<FurnitureOrder> re= new ResponseEntity<FurnitureOrder>(user2, HttpStatus.OK);
		return re;
	}

	
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrderDetails() throws UserNotFoundException {

		List<FurnitureOrder> resultFurniture = osi.getAllOrders();
		return new ResponseEntity<List<FurnitureOrder>>(resultFurniture, HttpStatus.OK);

	}
}

