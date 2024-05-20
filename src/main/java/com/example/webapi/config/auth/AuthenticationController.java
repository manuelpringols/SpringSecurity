package com.example.webapi.config.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		// Il RegisterRequest avra il compito di accumulare tutte le richiste o le
		// informazioni tipo nome, cognome etc
		
		return ResponseEntity.ok(service.register(request));
		
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		// Il RegisterRequest avra il compito di accumulare tutte le richiste o le
		// informazioni tipo nome, cognome etc
	
		return ResponseEntity.ok(service.authenticate(request));

		
		
	}
	
	
	
}
