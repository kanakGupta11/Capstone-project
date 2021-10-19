package com.example.rechargeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Operator;
import com.example.rechargeapp.models.Plan;

public interface OperatorRepository extends JpaRepository<Operator, Integer>{

}

