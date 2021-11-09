package com.service;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;

public interface OrderCancellationServiceInterface {

	String deleteOrder() throws OrderServiceException;
	FurnitureOrder deleteOrderById(String orderId) throws OrderServiceException;
}

