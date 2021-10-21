package com.example.rechargeapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.models.Payment;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.repository.CustomerRepository;
import com.example.rechargeapp.repository.PaymentRepository;
import com.example.rechargeapp.repository.PlanRepository;

public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
//	@Autowired
//	PlanRepository planRepository;
	
//	@Autowired
//	CustomerRepository customerRepository;
	
//	public Payment getPaymentById(Payment payment) {
//		return paymentRepository.findByPaymentId(payment.getPaymentId());
//	}
//	
//	public List<Payment> getPaymentsByCustomerId(Customer customer) {
//		return paymentRepository.findByCustomerId(customer.getCustomerId());
//	}
	
	// to be tested urgently
//	public int makePayment(int planId,int customerId) {
//		Plan plan = planRepository.findByPlanId(planId);
//		int planAmount = plan.getPlanCost();
//		Customer customer = customerRepository.findByCustomerId(customerId);
//		String customerName = customer.getFirstName()+' '+customer.getLastName();
//	    Payment payment = new Payment(customerId,customerName,planId);
//	    paymentRepository.save(payment);
//	    return payment.getPaymentId();
//	}

	
}
