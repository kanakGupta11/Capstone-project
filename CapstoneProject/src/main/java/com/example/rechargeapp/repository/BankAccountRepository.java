package com.example.rechargeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.BankAccount;
import com.example.rechargeapp.models.Customer;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

	String deleteByAccountId(int accountId);
	BankAccount findByAccountId(int accountId);
	List<BankAccount> findByCustomer(Customer customer);
}
