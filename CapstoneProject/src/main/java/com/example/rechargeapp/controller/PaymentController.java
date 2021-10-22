package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Payment;
import com.example.rechargeapp.service.PaymentService;

@RequestMapping("/recharge/payment")
@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("{bankAccountId}/{planId}/{customerId}")
	public String doPayment(@PathVariable Integer bankAccountId,@PathVariable Integer planId,@PathVariable Integer customerId ) {
		return paymentService.makePayment(bankAccountId, planId, customerId);
	}
	
	@PostMapping("{bankAccountId}/{planId}/{customerId}/{offerId}")
	public String doPayment(@PathVariable Integer bankAccountId,@PathVariable Integer planId,@PathVariable Integer customerId,@PathVariable Integer offerId ) {
		return paymentService.makePaymentWithOffer(bankAccountId, planId, customerId,offerId);
	}

	@GetMapping("/{paymentId}")
	public Payment getPaymentById(@PathVariable int paymentId) {
		return paymentService.getPaymentDetails(paymentId);
	}

	@GetMapping("/customer/{customerId}")
	public List<Payment> getAllPaymentsByCustomer(@PathVariable int customerId) {
		return paymentService.getPaymentsByCustomer(customerId);
	}

}
