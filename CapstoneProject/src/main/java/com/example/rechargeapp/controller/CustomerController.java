package com.example.rechargeapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.Status;
import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.service.CustomerService;

import antlr.collections.List;

@RequestMapping("rechargeApp/customers")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/signUp")
	public Status signUpUser(@Valid @RequestBody Customer customer) {
		java.util.List<Customer> customers = customerService.findAllCustomers();
		for(Customer cus:customers) {
			if(cus.equals(customer)) {
				System.out.println("User already exists in database!!");
				return Status.USER_ALREADY_EXISTS;
			}
			
		}
		customerService.save(customer);
		
		return Status.SUCCESS;
	}
	
	@PostMapping("/login")
	public Status loginUser(@Valid @RequestBody Customer customer) {
		java.util.List<Customer> customers = customerService.findAllCustomers();
		for(Customer cus : customers) {
			if(cus.equals(customer)) {
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	

}
