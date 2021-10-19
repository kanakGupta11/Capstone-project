package com.example.rechargeapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.repository.PlanRepository;
@Service
public class PlanService {
	@Autowired
	PlanRepository planRepository;
	
	//method to save plans
	public void savePlan(Plan plan) {
		planRepository.save(plan);
		System.out.println(plan);
		}
	
	//method to get plans
	public java.util.List<Plan> getPlans(){
		return planRepository.findAll();
	}
	
	//method to get plans by id
	public Plan getPlanById(int planId){
		return planRepository.findByPlanId(planId);
	}
}
