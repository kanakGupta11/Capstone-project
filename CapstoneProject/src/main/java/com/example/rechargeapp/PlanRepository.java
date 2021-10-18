package com.example.rechargeapp;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

	Plan findByPaymentId(int planId);

}
