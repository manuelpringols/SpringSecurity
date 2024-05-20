package com.example.webapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.webapi.entity.Autori;

public interface AutoriRepository extends JpaRepository<Autori,Integer>  {
	
		@Query(value = "select * from autori", nativeQuery = true)
		 List<Autori> cercaAutori();
		
		@Query(value = "select * from autori where nome = :nomeAutore", nativeQuery = true)
		 List<Autori> cercaAutoriPerNome(@Param("nomeAutore") String nomeAutore);
}
