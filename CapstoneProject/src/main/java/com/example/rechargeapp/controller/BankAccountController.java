package com.example.rechargeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.service.BankAccountService;

@RequestMapping("rechargeapp/v1")
@RestController
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping("/user/addAccount")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String addNewAccount(@RequestBody BankAccount bankAccount) {
		return bankAccountService.addAccount(bankAccount);
	}
	
	@DeleteMapping("/user/account/delete/{accountId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String deleteAccount(@PathVariable int accountId) {
		return bankAccountService.deleteAccount(accountId);
	}
	
	@GetMapping("/user/account/{accountId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public BankAccount getCustomerBankAccount(@PathVariable int accountId) {
		return bankAccountService.getAccount(accountId);
	}
	
	@GetMapping("/account/all/{customerId}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<BankAccount> getAllBankAccounts(@PathVariable int customerId) {
		return bankAccountService.getAllAccounts(customerId);
	}
}
