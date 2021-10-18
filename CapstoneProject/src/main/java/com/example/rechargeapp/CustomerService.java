package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository repository;
	
	public void save(Customer customer) {
		repository.save(customer);
		System.out.println("Customer added successfully!!");
	}
	

}
