package com.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.transaction.annotation.Transactional;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;
import com.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements OrderServiceInterface {

	
	@Autowired
	public OrderRepository od;

	
	@Transactional
	@Override
	public List<FurnitureOrder> getAllOrders() {
		
		List<FurnitureOrder> getFurniture = od.findAll();
		
		return getFurniture;
	}


	
	@Transactional
	@Override
	public FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException {
		if ((order != null)) {

			
			FurnitureOrder updateUser = od.save(order);
			
			return updateUser;

		} else {
			throw new UserNotFoundException("Order no exist");

		}
	}

	
	@Transactional
	@Override
	public FurnitureOrder updateOrderById(String orderId, FurnitureOrder order) throws UserNotFoundException {
		
		String orderid=order.getOrderId();
		Supplier s1= ()->new UserNotFoundException("Order Does not exist in the database");
		FurnitureOrder o1=od.findById(orderid).orElse(null);
		o1.setOrderId(order.getOrderId());
		o1.setOrderDate(order.getOrderDate());
		o1.setQuanity(order.getQuanity());
		o1.setPrice(order.getPrice());
		o1.setStatus(order.getStatus());
		od.save(o1);
		return od.save(o1);
		
		
		

}
}

