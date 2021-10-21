package com.example.rechargeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.repository.BankAccountRepository;

@Service
public class BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;

	public String addAccount(BankAccount bankAccount) {
		bankAccountRepository.save(bankAccount);
		return "A new bank account added successfully";
	}

	public String deleteAccount(int accountId) {
		bankAccountRepository.deleteByAccountId(accountId);
		return null;
	}

	public BankAccount getAccount(int accountId) {
		return bankAccountRepository.findByAccountId(accountId);
	}

	public List<BankAccount> getAllAccounts(Integer customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		return bankAccountRepository.findByCustomer(customer);
	}

}
