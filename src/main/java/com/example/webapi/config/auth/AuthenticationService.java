package com.example.webapi.config.auth;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.webapi.config.JwtService;
import com.example.webapi.config.Role;
import com.example.webapi.config.User;
import com.example.webapi.config.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {// Questo metodo register ci permetterà di creare e
																		// salvare uno user nel nostro database e
		var user = User.builder()
				.nome(request.getNome())
				.cognome(request.getCognome())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
				repository.save(user);
				var jwtToken = jwtService.generateToken(user);
				// ritornare da esso, il generatedToken
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
				

	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
				request.getEmail(),
				request.getPassword()
				) 
				);// l'autenticationManager ha bisogno di username e password per funzionare 
				
			var user = repository.findByEmail(request.getEmail()).orElseThrow();
		
		
		 var jwtToken = jwtService.generateToken(user);
		// ritornare da esso, il generatedToken
return AuthenticationResponse.builder()
		.token(jwtToken)
		.build();

	}

}
