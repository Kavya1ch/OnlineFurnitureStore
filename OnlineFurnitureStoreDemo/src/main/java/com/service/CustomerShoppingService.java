package com.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;
import com.exception.FurnitureServiceException;
import com.repository.CustomerRepository;
import com.repository.IFurnitureRepository;
import com.repository.IShopingCartRepository;
import com.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerShoppingService implements CustomerShoppingServiceInterface {

	
	@Autowired
	private IFurnitureRepository furnitureRepo;
	@Autowired
	IShopingCartRepository cartRepo;
	@Autowired
	public OrderRepository orderRepo;
    @Autowired
    public CustomerRepository cup;
	
	@Transactional
	@Override
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException{
		try {
		
		List<Furniture> resultFurniture = furnitureRepo.findAll();
		if(resultFurniture!=null) {
		
		return resultFurniture;
		}
		else {
			throw new CustomerShoppingException("The Furniture is empty");
		}
		}
		catch(Exception e) {
			throw new CustomerShoppingException("The Furniture is empty");
		}
	}

	
	@Transactional
	@Override
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException {

		try {
			
			Furniture result = furnitureRepo.findbyName(furnitureName);
				
				return result; 
		}
		catch (Exception e) {
			throw new CustomerShoppingException("Furniture nor found");
		}
	}
	
	@Override
	public Customer addCustomerDetails(Customer cd) {
	return cup.save(cd);
	}
	@Transactional
 @Override
	public Cart addtoCart(Cart cart) {
	return cartRepo.save(cart);
	}
	@Transactional
	@Override
	public FurnitureOrder placeOrder(FurnitureOrder order) {
	return orderRepo.save(order);
	}
	
	
	
	
}
