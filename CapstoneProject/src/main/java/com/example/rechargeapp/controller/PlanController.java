package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.PlanService;

@RequestMapping("rechargeApp/plans")
@RestController
public class PlanController {
	@Autowired
	PlanService planService;

	@PostMapping("/savePlans")
	public void planSave(@RequestBody Plan plan) {
		planService.savePlan(plan);
	}

	@GetMapping("/getPlans/{operatorId}")
	public List<Plan> getAllPlans(@PathVariable("operatorId") Integer operatorId) {
		return planService.getPlans(operatorId);
	}

	@GetMapping("/customers/getPlans/{operatorId}/{planId}")
	public Plan getByPlansId(@PathVariable int planId) {
		return planService.getPlanById(planId);
	}

}
