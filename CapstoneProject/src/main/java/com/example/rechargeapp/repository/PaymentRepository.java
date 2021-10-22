package com.example.rechargeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByPaymentId(int paymentId);
	List<Payment> findByCustomer(Customer customer);
}
