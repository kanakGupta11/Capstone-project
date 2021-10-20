package com.example.rechargeapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.rechargeapp.repository.PaymentRepository;

public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
}
