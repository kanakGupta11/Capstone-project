package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
		System.out.println("Customer added successfully!!");
	}
	

}
