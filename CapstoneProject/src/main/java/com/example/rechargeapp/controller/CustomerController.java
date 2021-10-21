package com.example.rechargeapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rechargeapp.models.Customer;
import com.example.rechargeapp.models.ERole;
import com.example.rechargeapp.models.Offer;
import com.example.rechargeapp.models.Plan;
import com.example.rechargeapp.models.Role;
import com.example.rechargeapp.repository.CustomerRepository;
import com.example.rechargeapp.repository.RoleRepository;
import com.example.rechargeapp.service.CustomerService;
import com.example.rechargeapp.service.OfferService;
import com.example.rechargeapp.service.PlanService;
import com.example.rechargeapp.springjwt.payload.request.LoginRequest;
import com.example.rechargeapp.springjwt.payload.request.SignupRequest;
import com.example.rechargeapp.springjwt.payload.response.JwtResponse;
import com.example.rechargeapp.springjwt.payload.response.MessageResponse;
import com.example.rechargeapp.springjwt.security.jwt.JwtUtils;
import com.example.rechargeapp.springjwt.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("rechargeapp/customers")
@RestController
public class CustomerController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	PlanService planService;
	
	@Autowired
	OfferService offerService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = (List) userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return (ResponseEntity<?>) ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (customerRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error : Username already exists!!"));
		}

		if (customerRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error : Email is already in use!!"));
		}
		Customer customer = new Customer(signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getFirstName(), signUpRequest.getLastName(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getMobileNumber(), signUpRequest.getGender(), signUpRequest.getDateOfBirth(),
				signUpRequest.getCreatedDate(), signUpRequest.getUpdatedDate());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error : Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error : Role is not found."));
					roles.add(adminRole);

					break;

				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error : Role is not found."));
					roles.add(userRole);
				}

			});
		}
		customer.setRoles(roles);
		customerRepository.save(customer);
		return ResponseEntity.ok(new MessageResponse("Customer added successfully!!"));
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('USER')")
	public String deleteUser(@PathVariable int id) {
		if(customerRepository.findById(id).equals(null)) {
			throw new NullPointerException("User doesn't exists!!");
		}
		customerService.deleteUser(id);
		return "User with CustomerId : " + id + " deleted successfully!!";
	}
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Customer updatedCustomer){
		customerService.updateCustomer(id, updatedCustomer);
		return ResponseEntity.ok(new MessageResponse("Customer details updated successfully!!"));
	}
	
	@GetMapping("/getPlans/{operatorId}")
	@PreAuthorize("hasRole('USER')")
	public List<Plan> getAllPlans(@PathVariable Integer operatorId){
		return planService.getPlans(operatorId);
	}
	
	@GetMapping("/getOffers")
	@PreAuthorize("hasRole('USER')")
	public List<Offer> getAllOffers(){
		return offerService.getAllOffer();
	}
}
