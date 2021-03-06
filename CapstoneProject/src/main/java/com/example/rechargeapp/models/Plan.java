package com.example.rechargeapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "operator_id")
    // @JsonIgnore
    private Operator operator;

    @NotNull
    private int planCost;
    @NotNull
    private String planDetails;

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public int getPlanCost() {
        return planCost;
    }

    public void setPlanCost(int planCost) {
        this.planCost = planCost;
    }

    public String getPlanDetails() {
        return planDetails;
    }

    public void setPlanDetails(String planDetails) {
        this.planDetails = planDetails;
    }

}
