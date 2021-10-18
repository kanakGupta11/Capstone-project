package com.example.rechargeapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.repository.PlanRepository;
@Service
public class PlanService {
	@Autowired
	PlanRepository planRepository;
	public void savePlan(Plan plan) {
		planRepository.save(plan);
		System.out.println(plan);
		}
}
