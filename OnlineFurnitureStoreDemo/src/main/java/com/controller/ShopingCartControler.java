package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.exception.ShopingCartException;
import com.service.ShopingCartServiceInterface;


@RestController
@RequestMapping("/api/showCart")
public class ShopingCartControler {
	@Autowired
	ShopingCartServiceInterface shopingcartservice;

	
	@GetMapping(path = "/getAllCarts", produces = "application/json")
	public ResponseEntity<List<Cart>> getAllCarts() throws ShopingCartException {
		List<Cart> resultCart = shopingcartservice.getAllCarts();
		return new ResponseEntity<List<Cart>>(resultCart, HttpStatus.OK);
	}

	
	@GetMapping(path = "/getCartDetails/{cartId}", produces = "application/json")
	public ResponseEntity<Object> getCartById(@PathVariable int cartId) throws ShopingCartException
	{
		Cart resultCart;
		try {
			resultCart = shopingcartservice.getCartById(cartId);
			return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	
	@DeleteMapping(path = "/deleteCart")
	public ResponseEntity<Object> deleteCart() throws ShopingCartException {
		try {
			return new ResponseEntity<Object>(shopingcartservice.deleteCart(), HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	
	@PutMapping("/updateCartById/{cartId}")
	public ResponseEntity<Object> updateCartById(@RequestBody Cart cart) throws ShopingCartException
	{
		Cart resultCart;
		try {
			resultCart = shopingcartservice.updateCartById(cart.getCartId(), cart);
			return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	
	@DeleteMapping(path = "/deleteCartById/{cartId}", produces = "application/json")
	public ResponseEntity<Object> deleteCartById(@PathVariable int cartId) throws ShopingCartException{
		try {
			return new ResponseEntity<Object>(shopingcartservice.deleteCartById(cartId), HttpStatus.OK);
		} catch (ShopingCartException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

