package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffersService {
	@Autowired
	OffersRepository offersRepository;
	
	public void save(Offers offer) {
		offersRepository.save(offer);
		System.out.println("Offer added successfully!!");
	}
	

}
