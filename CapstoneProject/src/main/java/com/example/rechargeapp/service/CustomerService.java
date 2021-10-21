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

	public void deleteUser(Integer customerId) {
		customerRepository.deleteById(customerId);
	}

	public Customer updateCustomer(Integer id, Customer updatedCustomer) {
		Customer customer = customerRepository.findByCustomerId(id);
		String newUsername = updatedCustomer.getUsername();
		customer.setUsername(updatedCustomer.getUsername());
		customer.setPassword(updatedCustomer.getPassword());
		customer.setEmail(updatedCustomer.getEmail());
		customer.setMobileNumber(updatedCustomer.getMobileNumber());
		customerRepository.save(customer);
		return customer;

	}

}
