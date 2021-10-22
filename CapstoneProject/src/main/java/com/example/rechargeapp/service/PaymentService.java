package com.example.rechargeapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.models.Payment;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.repository.BankAccountRepository;
import com.example.rechargeapp.repository.CustomerRepository;
import com.example.rechargeapp.repository.OfferRepository;
import com.example.rechargeapp.repository.PaymentRepository;
import com.example.rechargeapp.repository.PlanRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OfferRepository offerRepository;

	public String makePayment(Integer bankAccountId, Integer planId, int customerId) {
		Plan plan = planRepository.findByPlanId(planId);
		BankAccount bankAccount = bankAccountRepository.findByAccountId(bankAccountId);
		int planAmount = plan.getPlanCost();
		int accountBalance = bankAccount.getAccountBalance();
		if (planAmount <= accountBalance) {
			bankAccount.setAccountBalance(accountBalance - planAmount);
			bankAccountRepository.save(bankAccount);
		} else {
			return "Insufficient Balance";
		}

		Customer customer = new Customer();
		customer.setCustomerId(customerId);

		Plan newPlan = new Plan();
		newPlan.setPlanId(planId);

		Payment payment = new Payment(customer, newPlan,planAmount);
		paymentRepository.save(payment);
		return "Your payment has been done successfully";
	}

	public Payment getPaymentDetails(int paymentId) {
		return paymentRepository.findByPaymentId(paymentId);
	}

	public List<Payment> getPaymentsByCustomer(Integer customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return paymentRepository.findByCustomer(customer);
	}

	public String makePaymentWithOffer(Integer bankAccountId, Integer planId, Integer customerId, Integer offerId) {
		Plan plan = planRepository.findByPlanId(planId);
		BankAccount bankAccount = bankAccountRepository.findByAccountId(bankAccountId);
		int planAmount = plan.getPlanCost();
		int discount = (offerRepository.findByOfferId(offerId)).getOfferAmount();
		int accountBalance = bankAccount.getAccountBalance();
		planAmount -= discount;
		if (planAmount <= accountBalance) {
			bankAccount.setAccountBalance(accountBalance - planAmount);
			bankAccountRepository.save(bankAccount);
		} else {
			return "Insufficient Balance";
		}

		Customer customerForPayment = new Customer();
		customerForPayment.setCustomerId(customerId);

		Plan planForPayment = new Plan();
		planForPayment.setPlanId(planId);
		
		Offer offerForPayment = new Offer();
		offerForPayment.setOfferId(offerId);

		Payment payment = new Payment(customerForPayment, planForPayment,offerForPayment,planAmount);
		paymentRepository.save(payment);
		return "Your payment has been done successfully";
	}

}
