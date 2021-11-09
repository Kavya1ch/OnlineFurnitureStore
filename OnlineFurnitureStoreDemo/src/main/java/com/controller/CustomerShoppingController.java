package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.entity.FurnitureUser;
import com.exception.CustomerShoppingException;
import com.exception.UserNotFoundException;
import com.service.CustomerShoppingServiceInterface;

@RestController
@RequestMapping("/api/ShowCustomerShopping")

public class CustomerShoppingController {

	@Autowired

	private CustomerShoppingServiceInterface onlineFurnitureStoreService;

	
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws CustomerShoppingException {
		List<Furniture> resultFurniture = onlineFurnitureStoreService.getAllFurnitures();
		return  new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);
	}

	
	@GetMapping(path = "/getFurnitureDetails/{furnitureName}")
	public ResponseEntity<Furniture> getFurniture(@PathVariable("furnitureName") String furnitureName) throws CustomerShoppingException {
		
		Furniture resultFurniture=onlineFurnitureStoreService.getFurnitureByName(furnitureName);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}
	@PostMapping(path="/add Customerdetails")
	public  ResponseEntity<Customer> addCustomerDetails(@RequestBody Customer customer) throws CustomerShoppingException {
		Customer c1 = onlineFurnitureStoreService.addCustomerDetails(customer);
		return new ResponseEntity<Customer>(c1, HttpStatus.OK);
	}

	
	@PostMapping(path="/add_cart")
	public  ResponseEntity<Cart> addFurniture(@RequestBody Cart cart) throws CustomerShoppingException {
		Cart furniture1 = onlineFurnitureStoreService.addtoCart(cart);
		return new ResponseEntity<Cart>(furniture1, HttpStatus.OK);
	}
	/*@PostMapping(path = "/loginUser")
	public ResponseEntity<FurnitureUser> loginUser(@RequestBody FurnitureUser user) throws UserNotFoundException {
		
		FurnitureUser user3 = umsd.loginUser(user);
		return new ResponseEntity<FurnitureUser>(user3, HttpStatus.OK);
	}*/

	
	@PostMapping(path="/place_order")
	public ResponseEntity<FurnitureOrder> placeOrder(@RequestBody FurnitureOrder furnitureorder) throws CustomerShoppingException {
		FurnitureOrder furniture1 = onlineFurnitureStoreService.placeOrder(furnitureorder);
		return new ResponseEntity<FurnitureOrder>(furniture1, HttpStatus.OK);

	}

}

