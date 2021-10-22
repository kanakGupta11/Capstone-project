package com.example.rechargeapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

    @Transactional
    public String deleteOfferById(int offerId) {
        offerRepository.deleteByOfferId(offerId);
        return "offer has been deleted successfully";
    }

    public String updateOffer(Offer offer, int offerId) {
        Offer updatedOffer = offerRepository.findByOfferId(offerId);
        updatedOffer.setOfferValidity(offer.getOfferValidity());
        updatedOffer.setOfferUpdatedDate(new Date());
        updatedOffer.setOfferAmount(offer.getOfferAmount());
        offerRepository.save(updatedOffer);
        return "offer updated successfully!!";
    }
}
