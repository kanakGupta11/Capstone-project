package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.repository.CustomerRepository;
import com.example.rechargeapp.repository.RoleRepository;
import com.example.rechargeapp.service.BankAccountService;
import com.example.rechargeapp.service.CustomerService;
import com.example.rechargeapp.service.OfferService;
import com.example.rechargeapp.service.PlanService;
import com.example.rechargeapp.springjwt.payload.response.MessageResponse;
import com.example.rechargeapp.springjwt.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rechargeapp/v1")
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PlanService planService;
	
	@Autowired
	OfferService offerService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	BankAccountService bankAccountService;
	
	@DeleteMapping("/user/delete/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String deleteUser(@PathVariable int id) {
		if(customerRepository.findById(id).equals(null)) {
			throw new NullPointerException("User doesn't exists!!");
		}
		customerService.deleteUser(id);
		return "User with CustomerId : " + id + " deleted successfully!!";
	}
	
	@PutMapping("/user/update/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Customer updatedCustomer){
		customerService.updateCustomer(id, updatedCustomer);
		return ResponseEntity.ok(new MessageResponse("Customer details updated successfully!!"));
	}
	
	@GetMapping("/user/getPlans/{operatorId}")
	@PreAuthorize("hasRole('USER')")
	public List<Plan> getAllPlans(@PathVariable Integer operatorId){
		return planService.getPlans(operatorId);
	}
	
	@GetMapping("/user/getOffers")
	@PreAuthorize("hasRole('USER')")
	public List<Offer> getAllOffers(){
		return offerService.getAllOffer();
	}
	
	@GetMapping("/user/account/{id}")
	@PreAuthorize("hasRole('USER')")
	public List<BankAccount> getAllAccounts(@PathVariable int id){
		return bankAccountService.getAllAccounts(id);
	}
}
