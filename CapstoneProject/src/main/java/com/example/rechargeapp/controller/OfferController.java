package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.OfferService;

@RequestMapping("recharge/offers")
@RestController
public class OfferController {
	@Autowired
	OfferService offerService;

	@PostMapping
	public void offerSave(@RequestBody Offer offer) {
		offerService.saveOffer(offer);
	}

	@GetMapping
	public List<Offer> offer() {
		return offerService.getAllOffer();
	}

	@GetMapping("/{offerId}")
	public Offer selectOfferById(@PathVariable int offerId) {
		return offerService.getOfferById(offerId);
	}

	@DeleteMapping("/{offerId}")
	public String deleteOffer(@PathVariable int offerId) {
		return offerService.deleteOfferById(offerId);
	}

	@PutMapping("{offerId}")
	public String offerUpdate(@RequestBody Offer offer, @PathVariable int offerId) {
		return offerService.updateOffer(offer, offerId);
	}
}
