package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.OfferService;


@RequestMapping("rechargeApp/Offers")
@RestController
public class OfferController {
	
	@Autowired
	OfferService offerService;
	
	@PostMapping("/saveOffer")
	public void offerSave(@RequestBody Offer offer) {
		offerService.saveOffer(offer);
	}
	
	
	@GetMapping("/getAllOffer")
	public List<Offer> offer(){
		return offerService.getAllOffer();
	}
	@GetMapping("/getOffer/{offerId}")
	public Offer selectOfferById(@PathVariable int offerId){
		return offerService.getOfferById(offerId);
	}
}
