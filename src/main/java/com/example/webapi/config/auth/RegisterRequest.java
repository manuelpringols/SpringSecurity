package com.example.webapi.config.auth;

import com.example.webapi.config.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private Role role;
}
