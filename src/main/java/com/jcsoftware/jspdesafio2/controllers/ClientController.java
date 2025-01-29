package com.jcsoftware.jspdesafio2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcsoftware.jspdesafio2.dtos.ClientDTO;
import com.jcsoftware.jspdesafio2.services.ClientService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable){
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto){
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id,@Valid @RequestBody ClientDTO dto){
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ClientDTO> delete(@PathVariable Long id){
		
	}
		
	

}
