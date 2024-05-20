package com.example.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapi.entity.Autori;
import com.example.webapi.entity.Libri;
import com.example.webapi.entity.Recensioni;
import com.example.webapi.repository.AutoriRepository;


@SpringBootApplication
public class LibreriaWebApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaWebApi2Application.class, args);
	}
	
	
	
	 @Bean
	CommandLineRunner commandLineRunner(AutoriRepository autoriRepository
			) {
		return args -> {
			
			

}; 

	}
}
