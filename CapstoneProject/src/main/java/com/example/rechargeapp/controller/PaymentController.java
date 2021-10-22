package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Payment;
import com.example.rechargeapp.service.PaymentService;

@RequestMapping("/rechargeapp/v1")
@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("/user/payment/{bankAccountId}/{planId}/{customerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String doPaymentWithoutOffer(@PathVariable Integer bankAccountId,@PathVariable Integer planId,@PathVariable Integer customerId ) {
		return paymentService.makePayment(bankAccountId, planId, customerId);
	}
	
	@PostMapping("/user/payment/offer/{bankAccountId}/{planId}/{customerId}/{offerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String doPayment(@PathVariable Integer bankAccountId,@PathVariable Integer planId,@PathVariable Integer customerId,@PathVariable Integer offerId ) {
		return paymentService.makePaymentWithOffer(bankAccountId, planId, customerId,offerId);
	}

	@GetMapping("/user/transaction/{paymentId}")
	@PreAuthorize("hasRole('USER')")
	public Payment getPaymentById(@PathVariable int paymentId) {
		return paymentService.getPaymentDetails(paymentId);
	}

	@GetMapping("/user/history/{customerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Payment> getAllPaymentsByCustomer(@PathVariable int customerId) {
		return paymentService.getPaymentsByCustomer(customerId);
	}

}
