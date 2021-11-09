package com.service;



import com.entity.Bill;
import com.entity.Card;
import com.entity.Customer;

public interface PaymentServiceInterface {

	Bill getBillById(long billNo) throws Exception;
	double payByCash(double amount) throws Exception;
	Card payByCard(Card card) throws Exception;
	public Bill addBillDetails(Bill bill);

}

