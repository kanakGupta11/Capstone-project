package com.example.rechargeapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.repository.OfferRepository;

@Service
public class OfferService {
	@Autowired
	OfferRepository offerRepository;
	
	public void saveOffer(Offer offer) {
		offerRepository.save(offer);
		System.out.println("Offer added successfully!!");
	}

	public List<Offer> getAllOffer() {
		return offerRepository.findAll();
	}

	public Offer getOfferById(int offerId) {
		return offerRepository.findByOfferId(offerId);
	}
	

}
