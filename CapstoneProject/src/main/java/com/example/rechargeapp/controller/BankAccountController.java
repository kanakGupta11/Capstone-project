package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.service.BankAccountService;

@RequestMapping("recharge/accounts")
@RestController
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping
	public String addNewAccount(@RequestBody BankAccount bankAccount) {
		return bankAccountService.addAccount(bankAccount);
	}
	
	@DeleteMapping("/{accountId}")
	public String deleteAccount(@PathVariable int accountId) {
		return bankAccountService.deleteAccount(accountId);
	}
	
	@GetMapping("/{accountId}")
	public BankAccount getCustomerBankAccount(@PathVariable int accountId) {
		return bankAccountService.getAccount(accountId);
	}
	
	@GetMapping("/all/{customerId}")
	public List<BankAccount> getAllBankAccounts(@PathVariable int customerId) {
		return bankAccountService.getAllAccounts(customerId);
	}
}
