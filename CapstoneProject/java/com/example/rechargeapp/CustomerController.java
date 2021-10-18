package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("rechargeApp/customers")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/signUp")
	public void signUpUser(@RequestBody Customer customer) {
		customerService.save(customer);
	}
	

}
