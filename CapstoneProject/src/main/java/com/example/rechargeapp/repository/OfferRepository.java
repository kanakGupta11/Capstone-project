package com.example.rechargeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Offer;

public interface OfferRepository extends JpaRepository < Offer, Integer>{

	Offer findByOfferId(int offerId);
	;
}
