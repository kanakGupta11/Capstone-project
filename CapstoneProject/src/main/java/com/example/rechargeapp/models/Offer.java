package com.example.rechargeapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer offerId;
	@NotNull
	private int offerAmount;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date offerValidity;
	private Date offerUpdatedDate;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date offerCreatedDate;

	public Offer() {
		this.offerCreatedDate = new Date();
	}

	public int getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}

	public Date getOfferValidity() {
		return offerValidity;
	}

	public void setOfferValidity(Date offerValidity) {
		this.offerValidity = offerValidity;
	}

	public Date getOfferUpdatedDate() {
		return offerUpdatedDate;
	}

	public void setOfferUpdatedDate(Date offerUpdatedDate) {
		this.offerUpdatedDate = offerUpdatedDate;
	}

	public Date getOfferCreatedDate() {
		return offerCreatedDate;
	}

	public void setOfferCreatedDate(Date offerCreatedDate) {
		this.offerCreatedDate = offerCreatedDate;
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

}
