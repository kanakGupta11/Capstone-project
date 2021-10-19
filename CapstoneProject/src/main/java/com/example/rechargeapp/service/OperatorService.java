package com.example.rechargeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Operator;
import com.example.rechargeapp.repository.OperatorRepository;
@Service
public class OperatorService {
	@Autowired
	OperatorRepository operatorRepository;
	
	public void saveOperator(Operator operator) {
		operatorRepository.save(operator);
	}
	public List<Operator> getoperators() {
		return operatorRepository.findAll();
	}
}
