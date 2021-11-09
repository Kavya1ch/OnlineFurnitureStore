package com.service;

import java.util.List;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;

public interface OrderServiceInterface {

	List<FurnitureOrder> getAllOrders() throws UserNotFoundException;
	FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException;
	FurnitureOrder updateOrderById(String orderId,FurnitureOrder order) throws UserNotFoundException;
}
