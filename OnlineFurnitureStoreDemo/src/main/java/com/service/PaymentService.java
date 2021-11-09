package com.service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.entity.Bill;
import com.entity.Card;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.repository.BillRepository;
import com.repository.CardRepository;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentService implements PaymentServiceInterface {

	
	@Autowired
	BillRepository billRepository;
	OrderRepository orderRepository;
	CustomerRepository customerRepository;
	CardRepository cardrepository;
	@Override
	public Bill getBillById(long billNo) {
		return billRepository.findById(billNo).orElse(null);
	}

	@Override
	public double payByCash(double amount) throws Exception {
		String username = "mani";
		String email = "mani@gmail.com";
		Customer customer = customerRepository.findByEmail(email);
		Bill bill = billRepository.findByCustomer(username);
		double change = bill.getAmount() - amount;
		try {
			if (change == 0 || change < 0) {
				FurnitureOrder order = new FurnitureOrder(UUID.randomUUID().toString(), new Date(), bill.getFurniture(), customer,
						bill.getQuanity(), bill.getPrice(), bill.getAmount(), "paid");
				orderRepository.save(order);
			} else {
				throw new Exception("You need to pay: " + bill.getAmount());
			}
		} catch (Exception e) {
			
			throw e;
		}
		return change;
	}
	@Override
	public Card payByCard(Card card) throws Exception {
	return cardrepository.save(card);
	}
	@Override
	public Bill addBillDetails(Bill bill) {
	return billRepository.save(bill);
	}
/*
 * @Override public Card payByCard(Card card) throws Exception { String username
 * = "mani"; String email = "mani@gmail.com"; Customer customer =
 * customerRepository.findByEmail(email); Bill bill =
 * billRepository.findByCustomer(username); if (isCardValid(card)) {
 * FurnitureOrder order = new FurnitureOrder(UUID.randomUUID().toString(), new
 * Date(), bill.getFurniture(), customer, bill.getQuanity(), bill.getPrice(),
 * bill.getAmount(), "paid"); orderRepository.save(order); }
 * card.setCardNumber("XXXXXX"+card.getCardNumber().substring(card.getCardNumber
 * ().length()-3)); return card; }
 * 
 * private boolean isCardValid(Card card) throws Exception {
 * if(!(card.getCardNumber().equals(null)) && (card.getCvv()!=0)) { if
 * (card.getCvv() != 3) { throw new ReportException("Invalid CVV"); } if
 * (card.getCardNumber().length() != 9) { throw new
 * ReportException("Invalid card number"); } if (null == card.getCardExpiry()) {
 * throw new
 * ReportException("Card expirty date is invalid. Cause: ExpiryDate object is null"
 * ); } else { if(card.getCardExpiry().getYear()!=0 &&
 * card.getCardExpiry().getMonth()!=0) { if(card.getCardExpiry().getYear() <
 * Calendar.YEAR){ throw new
 * ReportException("Card expirty date is invalid. Cause: Expiry year is invalid"
 * ); } if((card.getCardExpiry().getMonth())> 12 ||
 * (card.getCardExpiry().getMonth()) < 0) { throw new
 * ReportException("Card expirty date is invalid. Cause: Expiry month is invalid"
 * ); } } } return true; } else { return false; }
 * 
 * } }
 * 
 */
}