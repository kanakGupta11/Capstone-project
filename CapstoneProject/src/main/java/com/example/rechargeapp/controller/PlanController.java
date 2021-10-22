package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.service.PlanService;

@RequestMapping("recharge/v1")
@RestController
public class PlanController {
    @Autowired
    PlanService planService;

    @PostMapping("/admin/plan")
    @PreAuthorize("hasRole('ADMIN')")
    public void planSave(@RequestBody Plan plan) {
        planService.savePlan(plan);
    }

    @GetMapping("/user/plans/{operatorId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Plan> getAllPlans(@PathVariable("operatorId") Integer operatorId) {
        return planService.getPlans(operatorId);
    }

    @GetMapping("/user/myPlan/{operatorId}/{planId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Plan getByPlansId(@PathVariable int planId) {
        return planService.getPlanById(planId);
    }
}
