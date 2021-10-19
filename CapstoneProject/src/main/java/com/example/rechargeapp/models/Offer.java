package com.example.rechargeapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer offerId;
	@NotNull
	private String offerDetail;
	@NotNull
	private Date offerValidity;
	private Date offerUpdatedDate;
	@NotNull
	private Date offerCreatedDate;
	
	public Offer() {
		this.offerCreatedDate=new Date();
	}
	
	public String getOfferDetail() {
		return offerDetail;
	}
	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
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
