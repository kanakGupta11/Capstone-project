package com.example.rechargeapp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Payment getPaymentById(Payment payment) {
		return paymentRepository.findByPaymentId(payment.getPaymentId());
	}
	
	public List<Payment> getPaymentsByCustomerId(Customer customer) {
		return paymentRepository.findByCustomerId(customer.getCustomerId());
	}
	
	
	public int makePayment(int planId,int customerId) {
		Plan plan = planRepository.findByPaymentId(planId);
		int planAmount = plan.getPlanCost();
		Customer customer = customerRepository.findByCustomerId(customerId);
		String customerName = customer.getFirstName()+' '+customer.getLastName();
	    Payment payment = new Payment(customerId,customerName,planId);
	    paymentRepository.save(payment);
	    return payment.getPaymentId();
	}

	
}
