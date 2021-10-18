package com.example.rechargeapp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	public Payment findByPaymentId(Integer paymentId);
	public List<Payment> findByCustomerId(Integer customerId);
}
