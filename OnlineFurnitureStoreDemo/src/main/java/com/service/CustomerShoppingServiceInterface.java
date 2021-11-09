package com.service;

import java.util.List;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;

public interface CustomerShoppingServiceInterface {

	List<Furniture> getAllFurnitures() throws CustomerShoppingException;

	Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException;
	public Customer addCustomerDetails(Customer cd);

	public Cart addtoCart(Cart cart) ;

	public FurnitureOrder placeOrder(FurnitureOrder order) ;
}

