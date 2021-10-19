package com.example.rechargeapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
		System.out.println("Signed Up successfully!!");
	}
	
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	
	

}
