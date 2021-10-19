package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.PlanService;

@RequestMapping("rechargeApp")
@RestController
public class PlanController {
	@Autowired
	PlanService planService;
	
	@PostMapping("/savePlans")
	public void planSave(@RequestBody Plan plan) {
		planService.savePlan(plan);
	}
	
	@GetMapping("/customers/getPlans")
	public List<Plan> getAllPlans(){
		return planService.getPlans();
	}
	@GetMapping("/customers/getPlans/{planId}")
	public Plan getByPlansId(@PathVariable int planId){
		return planService.getPlanById(planId);
	}
	

}
