package com.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.repository.BillRepository;
import com.repository.CustomerRepository;
import com.repository.IShopingCartRepository;
import com.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class ReportService implements ReportServiceInterface {

	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	IShopingCartRepository cartRepository;

	

	@Override
	public List<Bill> getAllBills() throws ReportException{
		
		List<Bill> bills = billRepository.findAll();
		
		return bills;
	}

	
	@Override
	public List<Customer> getAllCustomers() throws ReportException{
		
		List<Customer> customers = customerRepository.findAll();
		
		return customers;
	}

	
	@Override
	public List<Cart> getAllCarts() throws ReportException{
		
		List<Cart> carts = cartRepository.findAll();
		
		return carts;
	}

	@Override
	public List<FurnitureOrder> getAllOrders() throws ReportException{
		
		List<FurnitureOrder> orders = orderRepository.findAll();
		
		return orders;
	}

}
