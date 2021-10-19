package com.example.rechargeapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Operator {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer operatorId;
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	@NotNull
	private String operatorName;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Plan> planList;
	public List<Plan> getPlanList() {
		return planList;
	}
	public void setPlanList(List<Plan> planList) {
		this.planList = planList;
	}
}
