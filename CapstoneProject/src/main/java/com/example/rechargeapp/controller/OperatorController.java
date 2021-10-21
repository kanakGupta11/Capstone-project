package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Operator;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.OperatorService;
import com.example.rechargeapp.service.PlanService;

@RequestMapping("recharge/operators")
@RestController
public class OperatorController {
	@Autowired
	OperatorService operatorService;

	@PostMapping
	public void operatorSave(@RequestBody Operator operator) {
		operatorService.saveOperator(operator);
	}

	@GetMapping
	public List<Operator> getAllOperators() {
		return operatorService.getoperators();
	}
}
