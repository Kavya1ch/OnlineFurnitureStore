package com.service;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Cart;
import com.exception.ShopingCartException;
import com.repository.IShopingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ShopingCartService implements ShopingCartServiceInterface {

	
	@Autowired
	IShopingCartRepository shopingrepo;

	
	@Transactional
	@Override
	public List<Cart> getAllCarts() throws ShopingCartException {
		List<Cart> cartTemp = shopingrepo.findAll();
		
		if (cartTemp.isEmpty()) {
			throw new ShopingCartException("Cart not found");
		} else {
			List<Cart> getAllCarts = shopingrepo.findAll();
			
			return getAllCarts;
		}

	}

	
	@Transactional
	@Override
	public Cart getCartById(int cartId) throws ShopingCartException {
		
		Optional<Cart> cartTemp = shopingrepo.findById(cartId);
		if (cartTemp.isPresent() == false) {
			throw new ShopingCartException("CartId does not exist");
		} else {
			Cart getCart = shopingrepo.findById(cartId).orElse(null);
			
			return getCart;

		}
	}

	
	@Transactional
	@Override
	public Cart updateCartById(int cartId, Cart cart) throws ShopingCartException {
		
		Optional<Cart> cartTemp = shopingrepo.findById(cartId);
		if (cartTemp.isPresent() == false) {
			throw new ShopingCartException("Cart does not exist");
		} else {
			Cart updcart = shopingrepo.save(cart);
			
			return updcart;
		}
		
	}

	
	
	@Transactional
	@Override
	public String deleteCart() throws ShopingCartException {
		
		List<Cart> cartTemp = shopingrepo.findAll();
		if (cartTemp.isEmpty()) {
			throw new ShopingCartException("Cart not found");
		} else {
			shopingrepo.deleteAll();
			
			return "All carts deleted";
		}
	}

	
	
	@Transactional
	@Override
	public Cart deleteCartById(int cartId) throws ShopingCartException {
		
		Optional<Cart> cart = shopingrepo.findById(cartId);
		if (cart.isPresent()) {
			shopingrepo.delete(cart.get());
			
			return cart.get();
		} else {
			throw new ShopingCartException("Cart does not exist");
		}
	}
}
