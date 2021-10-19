package com.example.rechargeapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

	//Plan findByPlanId(int planId);

	//Plan findByPlanIdAndOperatorId(int planId, int operatorId);

	Plan findByPlanId(int planId);


}
