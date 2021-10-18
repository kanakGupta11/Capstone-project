package com.example.rechargeapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerId(int customerId);
	
}