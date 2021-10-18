package com.example.rechargeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	public void saveadmin(Admin admin) {
		adminRepository.save(admin);
		System.out.println(admin);
		}

}
