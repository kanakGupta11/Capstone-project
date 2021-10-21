package com.example.rechargeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.service.OfferService;

@RequestMapping("/rechargeapp/admin")
@RestController
public class AdminController {
	@Autowired
	OfferService offerService;
	
	@PostMapping("/addOffer")
	@PreAuthorize("hasRole('ADMIN')")
	public String addOffer(@RequestBody Offer offer) {
		offerService.saveOffer(offer);
		return "Offer added successfully!!";
	}
	
	@DeleteMapping("/deleteOffer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteOffer(@PathVariable Integer offerId) {
		offerService.deleteOfferById(offerId);
	}
	
	@PutMapping("/updateOffer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateOffer(@PathVariable Integer offerId, @RequestBody Offer offer) {
		offerService.updateOffer(offer, offerId);
	}	

}
