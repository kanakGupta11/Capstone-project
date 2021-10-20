package com.example.rechargeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

}
