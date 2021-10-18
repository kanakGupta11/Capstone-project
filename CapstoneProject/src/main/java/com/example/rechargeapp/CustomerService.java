package com.example.rechargeapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		customerRepository.save(customer);
		System.out.println("Signed Up successfully!!");
	}

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	
	

}
