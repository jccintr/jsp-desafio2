package com.jcsoftware.jspdesafio2.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcsoftware.jspdesafio2.dtos.ClientDTO;
import com.jcsoftware.jspdesafio2.entities.Client;
import com.jcsoftware.jspdesafio2.repositories.ClientRepository;
import com.jcsoftware.jspdesafio2.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> clients = repository.findAll(pageable);
		
		return clients.map(x -> new ClientDTO(x));
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		
		Optional<Client> clientO = repository.findById(id);
		Client client = clientO.orElseThrow(() -> new ResourceNotFoundException(id));
		ClientDTO dto = new ClientDTO();
		BeanUtils.copyProperties(client, dto);
		return dto;
		
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		
		Client newClient = new Client();
		BeanUtils.copyProperties(dto, newClient);
		newClient = repository.save(newClient);

		return new ClientDTO(newClient);
		
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		
		try {
			Client client = repository.getReferenceById(id);
			updateData(dto, client);
			client = repository.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw (new ResourceNotFoundException(id));
		}
		
	}
	
	public void delete(Long id) {
		
	}
	
	private void updateData(ClientDTO source, Client target) {
		
		target.setName(source.getName());
		target.setCpf(source.getCpf());
		target.setIncome(source.getIncome());
		target.setBirthDate(source.getBirthDate());
		target.setChildren(source.getChildren());
	}

}
