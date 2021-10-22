package com.example.rechargeapp.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "customer_id")
	private Customer customer;
	private Date dateOfPayment;
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "plan_id")
	private Plan plan;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	private int paymentAmount;
	
	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Payment() {

	}
	
	public Payment(Customer customer, Plan plan,int paymentAmount) {
		this.customer = customer;
		this.dateOfPayment = new Date();
		this.plan = plan;
		this.paymentAmount = paymentAmount;
	}

	public Payment(Customer customer, Plan plan, Offer offer,int paymentAmount) {
		this.customer = customer;
		this.dateOfPayment = new Date();
		this.plan = plan;
		this.offer = offer;
		this.paymentAmount = paymentAmount;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}
