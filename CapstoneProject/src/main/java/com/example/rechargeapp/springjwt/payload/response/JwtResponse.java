package com.example.rechargeapp.springjwt.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, Integer id, String username, String email, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.email = email;
		this.username = username;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
