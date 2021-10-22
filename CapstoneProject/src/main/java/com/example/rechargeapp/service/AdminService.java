package com.example.rechargeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rechargeapp.models.Admin;
import com.example.rechargeapp.repository.AdminRepository;
import com.example.rechargeapp.repository.CustomerRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void saveadmin(Admin admin) {
		adminRepository.save(admin);
		System.out.println(admin);
	}
	
	public void deleteUser(Integer customerId) {
		customerRepository.deleteById(customerId);
	}

}
