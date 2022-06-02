package com.apinoticias.syonet.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apinoticias.syonet.dto.ClientDTO;
import com.apinoticias.syonet.entities.Client;
import com.apinoticias.syonet.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
    
	@Transactional
	public ClientDTO register(ClientDTO dto) {
    Client object = new Client();
    copyDtoToEntity(dto, object);
    return new ClientDTO(object);
	}
	
	@Transactional(readOnly=true)
	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id).get();
		return new ClientDTO(client);
	}
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		Client client = clientRepository.findById(id).get();
		copyDtoToEntity(dto, client);
		client = clientRepository.save(client);
		return new ClientDTO(client);
	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	
	
	public void copyDtoToEntity(ClientDTO dto, Client entity) {
		entity.setBirthDate(dto.getBirthDate());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
	}
}
