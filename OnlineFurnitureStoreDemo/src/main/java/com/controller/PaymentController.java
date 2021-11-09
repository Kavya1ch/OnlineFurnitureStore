package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Card;
import com.entity.Customer;
import com.entity.FurnitureUser;
import com.exception.CustomerShoppingException;
import com.service.PaymentServiceInterface;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentServiceInterface paymentService;

	
	@GetMapping(path = "/getBillByIdeDetalis/{billNo}")
	public ResponseEntity<Bill> getBillById(@RequestParam long billNo) throws Exception {
		return new ResponseEntity<>(paymentService.getBillById(billNo), HttpStatus.OK);
	}

	
	@PutMapping("/payByCash/{amount}")
	public ResponseEntity<String> payByCash(@RequestParam double amount) throws Exception {
		double change = paymentService.payByCash(amount);
		if (change == 0) {
			return new ResponseEntity<>("Your transaction is completed.. ", HttpStatus.OK);
		} else if (change < 0) {
			return new ResponseEntity<>("Please take the change: " + change, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Your Due amount is: " + change, HttpStatus.OK);
		}
	}

	
	@PostMapping(path = "/payByCard")
	public ResponseEntity<Card> payByCard(@RequestBody Card card) throws Exception {
		Card result = paymentService.payByCard(card);
		return new ResponseEntity<Card>(result,HttpStatus.OK);
	}
	//	return new ResponseEntity<FurnitureUser>(user3, HttpStatus.OK);}
		@PostMapping(path="/add Billdetails")
		public  ResponseEntity<Bill> addBillDetails(@RequestBody Bill bill) throws Exception {
			Bill b1 = paymentService.addBillDetails(bill);
			return new ResponseEntity<Bill>(b1, HttpStatus.OK);
		}
}

