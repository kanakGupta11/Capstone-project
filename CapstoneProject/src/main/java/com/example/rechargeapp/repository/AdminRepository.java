package com.example.rechargeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rechargeapp.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
