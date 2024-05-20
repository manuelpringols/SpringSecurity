package com.example.webapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.webapi.entity.Autori;
import com.example.webapi.repository.AutoriRepository;

public class AutoriImpl implements AutoriService {
	
	@Autowired
	private AutoriRepository autoriRepository;
	@Override
	public List<Autori> SelTutti() {
		
		return autoriRepository.findAll();
	}
	
	

	
}
