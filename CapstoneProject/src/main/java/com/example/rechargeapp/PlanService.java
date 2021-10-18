package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlanService {
	@Autowired
	PlanRepository planRepository;
	public void savePlan(Plan plan) {
		planRepository.save(plan);
		System.out.println(plan);
		}
}
