package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Operator;
import com.example.rechargeapp.service.OperatorService;

@RequestMapping("rechargeapp/v1")
@RestController
public class OperatorController {
    @Autowired
    OperatorService operatorService;

    @PostMapping("/admin/operator")
    @PreAuthorize("hasRole('ADMIN')")
    public void operatorSave(@RequestBody Operator operator) {
        operatorService.saveOperator(operator);
    }

    @GetMapping("/user/operators")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Operator> getAllOperators() {
        return operatorService.getoperators();
    }
}
