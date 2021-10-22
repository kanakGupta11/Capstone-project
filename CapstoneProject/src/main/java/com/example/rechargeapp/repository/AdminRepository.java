package com.example.rechargeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rechargeapp.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
