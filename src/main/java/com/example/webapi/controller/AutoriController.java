package com.example.webapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapi.entity.Autori;
import com.example.webapi.repository.AutoriRepository;
import com.example.webapi.services.AutoriService;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

 
@RestController //Specifichiamo la classe come controller
@RequestMapping(value = "api/Autori") //
@CrossOrigin(origins = "http://localhost:4200")
public class AutoriController {

	@Autowired
	private AutoriRepository autoriRepository; //Auto injection della repository

	AutoriController(AutoriRepository repository) {
		autoriRepository = repository;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(produces = "application/json") //metodo per richiamare una lista di autori, specificando il content type in ingresso di tipo json.
	public Iterable<Autori> getAll() {
		return autoriRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@RequestMapping(value = "/addAutori", method = RequestMethod.POST, produces = "application/json")
	public Autori addAutore(@RequestBody Autori newAutore){
		return autoriRepository.save(newAutore);
		
		
		}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/cercaAutori",produces = "application/json")
	public List<Autori> cercaAutori(){
		return autoriRepository.cercaAutori();
	}
	@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping(value = "/cercaAutore/{id}",produces = "application/json")
		public Optional<Autori> cercaAutorePerId(@PathVariable Integer id){
			return autoriRepository.findById(id);
	}


		
			
		
			
		
	
}