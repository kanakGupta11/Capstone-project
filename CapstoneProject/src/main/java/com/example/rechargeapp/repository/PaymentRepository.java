package com.example.rechargeapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
}
