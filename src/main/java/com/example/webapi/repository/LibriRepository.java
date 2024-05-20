package com.example.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapi.entity.Libri;

public interface LibriRepository extends JpaRepository<Libri,String> {

}
