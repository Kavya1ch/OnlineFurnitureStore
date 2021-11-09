package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.entity.FurnitureOrder;
import com.entity.FurnitureUser;
import com.exception.OrderServiceException;
import com.exception.UserNotFoundException;
import com.repository.IOrderCancellation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCancellationService implements OrderCancellationServiceInterface {

	
	@Autowired
	IOrderCancellation orderRepo;

	
	@Transactional
	
	public String deleteOrder() throws OrderServiceException {
		
		List<FurnitureOrder> resultFurniture;
		try {
			resultFurniture = orderRepo.findAll();
			if (resultFurniture != null) {
				orderRepo.deleteAll();
				
				return "All Values are deleted successfully";
			} else {
				throw new OrderServiceException("There is no value in the furniture");
			}
		} catch (Exception e) {
			throw new OrderServiceException("There is no value in the furniture");
		}

	}

	/*public FurnitureUser deleteUserById(int uid) throws UserNotFoundException {
		Optional<FurnitureUser> del = umd.findById(uid);
		
		if (del == null) {
			throw new UserNotFoundException("No user found");
		}

		else {
			umd.deleteById(uid);
			if (del.isPresent()) {
				
				return del.get();
			} else {
				throw new UserNotFoundException("Not Present");
			}

		}
	}*/
	@Transactional
	
	public FurnitureOrder deleteOrderById(String orderId) throws OrderServiceException {
		Optional<FurnitureOrder> del = orderRepo.findById(orderId);
		
			
			//FurnitureOrder del = orderRepo.findById(orderId).orElse(null);
			if (del == null) {
				throw new OrderServiceException("no furniture found");
			} else {
				orderRepo.deleteById(orderId);
				
				if (del.isPresent()) {
					
					return del.get();
				} else {
					throw new OrderServiceException("Not Present");
				}

			}
		} 
	}


