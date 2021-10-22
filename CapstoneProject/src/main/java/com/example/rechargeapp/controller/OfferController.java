package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.service.OfferService;

@RequestMapping("rechargeapp/v1")
@RestController
public class OfferController {
	@Autowired
	OfferService offerService;

	@PostMapping("/admin/offers")
	@PreAuthorize("hasRole('ADMIN')")
	public void offerSave(@RequestBody Offer offer) {
		offerService.saveOffer(offer);
	}

	@GetMapping("/user/showOffers")
	@PreAuthorize("hasRole('USER')")
	public List<Offer> offer() {
		return offerService.getAllOffer();
	}

	@GetMapping("/user/selectOffer/{offerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Offer selectOfferById(@PathVariable int offerId) {
		return offerService.getOfferById(offerId);
	}

	@DeleteMapping("/admin/delete/{offerId}")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteOffer(@PathVariable int offerId) {
		return offerService.deleteOfferById(offerId);
	}

	@PutMapping("/admin/update/{offerId}")
	@PreAuthorize("hasRole('ADMIN')")
	public String offerUpdate(@RequestBody Offer offer, @PathVariable int offerId) {
		return offerService.updateOffer(offer, offerId);
	}
}
