package com.example.rechargeapp.springjwt.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rechargeapp.models.Admin;
import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.repository.AdminRepository;
import com.example.rechargeapp.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = customerRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username : " + username));
		return UserDetailsImpl.build(user);
	}
	


}
