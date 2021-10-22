package com.example.rechargeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.repository.CustomerRepository;
import com.example.rechargeapp.service.CustomerService;
import com.example.rechargeapp.service.OfferService;
import com.example.rechargeapp.springjwt.security.jwt.JwtUtils;

@RequestMapping("/rechargeapp/v1")
@RestController
public class AdminController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	OfferService offerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerService customerService;
	
//	@DeleteMapping("/admin/delete/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//	public String deleteUser(@PathVariable int id) {
//		if(customerRepository.findById(id).equals(null)) {
//			throw new NullPointerException("User doesn't exists!!");
//		}
//		customerService.deleteUser(id);
//		return "User with CustomerId : " + id + " deleted successfully!!";
//	}
	
	
//	@PostMapping("/admin/addOffer")
//	@PreAuthorize("hasRole('ADMIN')")
//	public String addOffer(@RequestBody Offer offer) {
//		offerService.saveOffer(offer);
//		return "Offer added successfully!!";
//	}
//	
//	@DeleteMapping("/admin/deleteOffer/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public void deleteOffer(@PathVariable Integer offerId) {
//		offerService.deleteOfferById(offerId);
//	}
//	
//	@PutMapping("/admin/updateOffer/{id}")
//	@PreAuthorize("hasRole('ADMIN')")
//	public void updateOffer(@PathVariable Integer offerId, @RequestBody Offer offer) {
//		offerService.updateOffer(offer, offerId);
//	}	

}
