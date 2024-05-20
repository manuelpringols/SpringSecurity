package com.example.webapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	

	
	private  final JwtAuthenticationFilter jwtAuthFilter;
	
	
	
	private  final AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { //Creiamo il filtro per le richieste http
		           //Settiamo le impostazioni dell HttpSecurity
		http 		//disabilitiamo il csrf
		.csrf()
		.disable()
		.authorizeHttpRequests()
		.requestMatchers("/**")
		.permitAll()//tutte le richieste passate nel requestMatcher avranno il permesso 
		.anyRequest()//mentre tutte le altre  richieste 
		.authenticated();//Devono essere autenticate 
		
		return http.build();
				}
}
