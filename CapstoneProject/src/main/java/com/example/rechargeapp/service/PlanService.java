package com.example.rechargeapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Operator;
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
	
	public java.util.List<Plan> getPlans(Integer operatorId){
		Operator operator = new Operator();
		operator.setOperatorId(operatorId);
		return planRepository.findByOperator(operator);
	}
	
	public Plan getPlanById(int planId){
		return planRepository.findByPlanId(planId);
	}
}
