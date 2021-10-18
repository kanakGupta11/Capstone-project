package com.example.rechargeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Admin;
import com.example.rechargeapp.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	public void saveadmin(Admin admin) {
		adminRepository.save(admin);
		System.out.println(admin);
		}

}
